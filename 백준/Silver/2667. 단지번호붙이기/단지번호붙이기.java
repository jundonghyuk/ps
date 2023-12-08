
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static char[][] board = new char[26][26];
    static boolean[][] vis = new boolean[26][26];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0 ; j < N; j++) {
                board[i][j] = line[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(vis[i][j] || board[i][j] == '0') continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                vis[i][j] = true;
                int count = 0;
                while(!q.isEmpty()) {
                    int[] location = q.poll();
                    count++;
                    for (int k = 0; k < 4; k++) {
                        int nx = location[0] + dx[k];
                        int ny = location[1] + dy[k];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (vis[nx][ny] || board[nx][ny] == '0') continue;
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
                ret.add(count);
            }
        }
        Collections.sort(ret);
        System.out.println(ret.size());
        for (Integer integer : ret) {
            System.out.println(integer);
        }
    }
}
