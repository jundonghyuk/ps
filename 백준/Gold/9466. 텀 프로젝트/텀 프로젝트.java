
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
                if(vis[i] > 0) {
                    continue;
                }
                vis[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                q.add(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    int next = board[cur];
                    if(set.contains(next)) {
                        cnt+= (vis[cur] - vis[next] + 1);
                        break;
                    }

                    if(vis[next] > 0) {
                        break;
                    }
                    vis[next] = vis[cur] + 1;
                    q.add(next);
                    set.add(next);
                }
            }
            System.out.println(N-cnt);
            cnt = 0;
        }
    }
}
