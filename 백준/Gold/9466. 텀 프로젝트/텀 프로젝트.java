
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T, N, cnt;
    static int[] vis = new int[100001];
    static int[] board =new int[100001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            vis = new int[100001];
            board =new int[100001];
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++ ) {
                if(vis[i] != 0) {
                    continue;
                }
                int cur = i;
                vis[cur] = i;
                while(true) {
                    cur = board[cur];
                    if(vis[cur] == i) {
                        while(vis[cur] == i) {
                            vis[cur] = -1;
                            cur = board[cur];
                        }
                        break;
                    } else if(vis[cur] != 0) {
                        break;
                    }
                    vis[cur] = i;
                }
            }
            for(int i = 1; i <= N; i++) {
                if(vis[i] != -1) {
                    cnt++;
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }
}
