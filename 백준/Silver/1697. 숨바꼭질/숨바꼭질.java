
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] vis = new boolean[100001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        vis[N] = true;

        while (!q.isEmpty()) {
            int[] location = q.poll();
            if (location[0] == K) {
                System.out.println(location[1]);
                return;
            }

            int nx = location[0] - 1;
            if (canGo(nx) && !vis[nx]) {
                vis[nx] = true;
                q.add(new int[]{nx, location[1] + 1});
            }

            nx = location[0] + 1;
            if (canGo(nx) && !vis[nx]) {
                vis[nx] = true;
                q.add(new int[]{nx, location[1] + 1});
            }

            nx = location[0] * 2;
            if (canGo(nx) && !vis[nx]) {
                vis[nx] = true;
                q.add(new int[]{nx, location[1] + 1});
            }
        }
    }

    static boolean canGo(int nx) {
        if (nx < 0 || nx > 100000) {
            return false;
        }
        return true;
    }
}
