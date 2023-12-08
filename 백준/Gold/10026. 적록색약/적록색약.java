
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static char[][] board = new char[101][101];
    static boolean[][] vis = new boolean[101][101];
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                board[i][j] = charArray[j];
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int notRG = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(vis[i][j]) {
                    continue;
                }
                q.add(new int[]{i, j});
                notRG++;
                vis[i][j] = true;
                while(!q.isEmpty()) {
                    int[] location = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = location[0] + dx[dir];
                        int ny = location[1] + dy[dir];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (vis[nx][ny]) continue;
                        if(board[nx][ny] != board[location[0]][location[1]]) continue;
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        vis = new boolean[101][101];
        q = new LinkedList<>();
        int rg = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(vis[i][j]) {
                    continue;
                }
                q.add(new int[]{i, j});
                rg++;
                vis[i][j] = true;
                while(!q.isEmpty()) {
                    int[] location = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = location[0] + dx[dir];
                        int ny = location[1] + dy[dir];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (vis[nx][ny]) continue;
                        if(board[location[0]][location[1]] == 'B') {
                            if(board[nx][ny] != 'B') {
                                continue;
                            }
                        } else {
                            if(board[nx][ny] == 'B') {
                                continue;
                            }
                        }
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        System.out.println(notRG + " " + rg);
    }
}
