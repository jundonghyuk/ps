
import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, YEAR;
    static int[][] board = new int[301][301];
    static boolean[][] vis = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] != 0) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        if(isSplitWithTwoOrMore()) {
            System.out.println(0);
            return;
        }

        int[][] temp = new int[301][301];
        while(!q.isEmpty()) {
            int[] loc = q.poll();
            if(loc[2] != YEAR) {
                for (int i = 0; i < N; i++) {
                    for(int j = 0; j < M; j++) {
                        board[i][j] -= temp[i][j];
//                        System.out.print(board[i][j] + " ");
                    }
//                    System.out.println();
                }
                YEAR++;
                temp = new int[301][301];
                if(isSplitWithTwoOrMore()) {
                    System.out.println(YEAR);
                    return;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = loc[0] + dx[i];
                int ny = loc[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(board[nx][ny] <= 0) {
                    temp[loc[0]][loc[1]]++;
                }
            }
            if(board[loc[0]][loc[1]] - temp[loc[0]][loc[1]] > 0) {
                q.add(new int[]{loc[0], loc[1], loc[2] + 1});
            }
        }
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                board[i][j] -= temp[i][j];
            }
        }
        YEAR++;
        if(isSplitWithTwoOrMore()) {
            System.out.println(YEAR);
            return;
        }
        System.out.println(0);
    }

    public static boolean isSplitWithTwoOrMore() {
        boolean[][] vis = new boolean[301][301];
        int cnt= 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(vis[i][j] || board[i][j] <= 0) continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                vis[i][j] = true;
                while(!q.isEmpty()) {
                    int[] loc = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = loc[0] + dx[dir];
                        int ny = loc[1] + dy[dir];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if(board[nx][ny] <= 0 || vis[nx][ny]) continue;
                        q.add(new int[]{nx, ny});
                        vis[nx][ny] = true;
                    }
                }
                cnt++;
            }
        }
        return cnt >= 2;
    }
}
