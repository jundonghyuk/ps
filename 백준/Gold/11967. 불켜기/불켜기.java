
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
        17:15 ~
 */
public class Main {

    static int N, M;
    static int[][] board = new int[101][101];
    static boolean[][] vis = new boolean[101][101];
    static boolean[][] light = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static HashMap<Position, List<Position>> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int tx = Integer.parseInt(st.nextToken()) - 1;
            int ty = Integer.parseInt(st.nextToken()) - 1;

            Position start = new Position(x, y);
            Position target = new Position(tx, ty);
            if (map.containsKey(start)) {
                map.get(start).add(target);
            } else {
                List<Position> temp = new ArrayList<>();
                temp.add(target);
                map.put(start, temp);
            }
        }
        vis[0][0] = true;
        light[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            int x = loc[0];
            int y = loc[1];

            // light up
            if (map.containsKey(new Position(x, y))) {
                List<Position> next = map.get(new Position(x, y));
                for (Position position : next) {
                    light[position.x][position.y] = true;
                    if (vis[position.x][position.y]) continue;
                    for (int i = 0; i < 4; i++) {
                        int nx = position.x + dx[i];
                        int ny = position.y + dy[i];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (vis[nx][ny]) {
                            q.add(new int[]{nx, ny});
                            vis[nx][ny] = true;
                            break;
                        }
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (vis[nx][ny]) continue;
                if (light[nx][ny]) {
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(light[i][j])  {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
