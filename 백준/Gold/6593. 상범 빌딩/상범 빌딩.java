
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L, R, C;

    static int[] dx = {1, 0, 0, -1, 0, 0};
    static int[] dy = {0, 1, 0, 0, -1, 0};
    static int[] dz = {0, 0, 1, 0, 0, -1};

    static char[][][] board = new char[31][31][31];
    static int[][][] vis = new int[31][31][31];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            board = new char[31][31][31];
            vis = new int[31][31][31];
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                return;
            }
            int[] start = new int[3];
            int[] end = new int[3];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    char[] chars = br.readLine().toCharArray();
                    for (int k = 0; k < C; k++) {
                        board[i][j][k] = chars[k];
                        vis[i][j][k] = -1;
                        if (chars[k] == 'S') {
                            start = new int[]{i, j, k};
                        }
                        if (chars[k] == 'E') {
                            end = new int[]{i, j, k};
                        }
                    }
                }
                br.readLine();
            }

            Queue<int[]> q = new LinkedList<>();
            q.add(start);
            vis[start[0]][start[1]][start[2]] = 0;
            boolean success = false;
            while (!q.isEmpty()) {
                int[] loc = q.poll();
                if (loc[0] == end[0] && loc[1] == end[1] && loc[2] == end[2]) {
                    System.out.println("Escaped in " + vis[loc[0]][loc[1]][loc[2]] + " minute(s).");
                    success = true;
                    break;
                }
                for (int i = 0; i < 6; i++) {
                    int x = loc[0] + dx[i];
                    int y = loc[1] + dy[i];
                    int z = loc[2] + dz[i];

                    if (x < 0 || y < 0 || z < 0 || x >= L || y >= R || z >= C) {
                        continue;
                    }
                    if(vis[x][y][z] != -1 || board[x][y][z] == '#') {
                        continue;
                    }

                    vis[x][y][z] = vis[loc[0]][loc[1]][loc[2]] + 1;
                    q.add(new int[]{x,y,z});
                }
            }
            if (!success) {
                System.out.println("Trapped!");
            }
        }
    }
}
