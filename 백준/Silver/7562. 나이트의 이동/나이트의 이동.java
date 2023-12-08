
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static boolean[][] vis = new boolean[301][301];
    static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = {-1, 1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int l = Integer.parseInt(br.readLine());
            String[] start = br.readLine().split(" ");
            String[] end = br.readLine().split(" ");
            int endX = Integer.parseInt(end[0]);
            int endY = Integer.parseInt(end[1]);
            vis = new boolean[301][301];

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{Integer.parseInt(start[0]), Integer.parseInt(start[1]), 0});
            vis[Integer.parseInt(start[0])][Integer.parseInt(start[1])] = true;

            while (!q.isEmpty()) {
                int[] location = q.poll();
                if (location[0] == endX && location[1] == endY) {
                    System.out.println(location[2]);
                    break;
                }
                for (int dir = 0; dir < 8; dir++) {
                    int nx = location[0] + dx[dir];
                    int ny = location[1] + dy[dir];

                    if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                    if (vis[nx][ny]) continue;

                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny, location[2] + 1});
                }
            }
        }
    }
}
