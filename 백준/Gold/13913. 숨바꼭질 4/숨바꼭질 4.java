
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] vis = new int[200001][2];
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        vis[N][0] = 0;
        q.add(N);
        while (!q.isEmpty()) {
            int loc = q.poll();
            if (loc == K) {
                System.out.println(vis[loc][0]);
                initDq(loc);
                break;
            }
            if (loc + 1 < 200001 && vis[loc + 1][0] == 0) {
                vis[loc + 1][0] = vis[loc][0] + 1;
                vis[loc + 1][1] = loc;
                q.add(loc + 1);
            }

            if (loc * 2 < 200001 && vis[loc * 2][0] == 0) {
                vis[loc * 2][0] = vis[loc][0] + 1;
                vis[loc * 2][1] = loc;
                q.add(loc * 2);
            }

            if (loc - 1 >= 0 && vis[loc - 1][0] == 0) {
                vis[loc - 1][0] = vis[loc][0] + 1;
                vis[loc - 1][1] = loc;
                q.add(loc - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k : dq) {
            sb.append(k);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static void initDq(int idx) {
        while (idx != N) {
            dq.addFirst(idx);
            idx = vis[idx][1];
        }
        dq.addFirst(N);
    }
}
