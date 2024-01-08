
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] board = new char[5][5];
    static boolean[][] temp = new boolean[5][5];
    static boolean[][] visited;
    static boolean[] team = new boolean[25];
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                board[i][j] = line[j];
            }
        }
        chooseTeam(0, 0);
        System.out.println(cnt);
    }

    public static void chooseTeam(int people, int next) {
        if (next >= 25 && people != 7) {
            return;
        }

        if (people == 7) {
            calculate();
            return;
        }
        team[next] = true;
        chooseTeam(people + 1, next + 1);
        team[next] = false;
        chooseTeam(people, next + 1);
    }

    public static void calculate() {
        Queue<int[]> q = new LinkedList<>();
        temp = new boolean[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 25; i++) {
            if (team[i]) {
                temp[i / 5][i % 5] = true;
                if (q.isEmpty()) {
                    q.add(new int[]{i / 5, i % 5});
                    visited[i / 5][i % 5] = true;
                }
            }
        }
        int adj = 0;
        int s = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (board[poll[0]][poll[1]] == 'S') {
                s++;
            }
            adj++;
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny] || !temp[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        if (adj == 7 && s >= 4) {
            cnt++;
        }
    }
}
