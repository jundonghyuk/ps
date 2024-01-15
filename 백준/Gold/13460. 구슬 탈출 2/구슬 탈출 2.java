
import java.util.Scanner;

/*
12:10 ~
 */
public class Main {

    static int n, m;
    static char[][] origin;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int success = 0;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        origin = new char[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            origin[i] = line.toCharArray();
        }
        rec(1, origin);
        System.out.println(ret == Integer.MAX_VALUE ? -1 : ret);
    }

    public static void rec(int depth, char[][] board) {
        if (depth == 11 || ret <= depth) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            char[][] tilt = tilt(board, i);
            if (success == 0) {
                rec(depth + 1, tilt);
            } else if (success == 1) {
                success = 0;
                ret = Math.min(ret, depth);
                return;
            } else {
                success = 0;
                continue;
            }
        }
    }

    public static char[][] tilt(char[][] board, int dir) {
        int[] red = new int[2];
        int[] blue = new int[2];
        int[] exit = new int[2];
        char[][] temp = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = board[i][j];
                if (board[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                }
                if (board[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
                if (board[i][j] == 'O') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        boolean move = false;
        boolean redEnd = true;
        while (true) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j <m;j++) {
//                    System.out.print(temp[i][j] +" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            move = false;
            if (red[0] + dx[dir] > 0 &&
                    red[0] + dx[dir] < n - 1 &&
                    red[1] + dy[dir] < m - 1 &&
                    red[1] + dy[dir] > 0 && redEnd) {
                red[0] += dx[dir];
                red[1] += dy[dir];
                if (temp[red[0]][red[1]] == '.') {
                    char tp = temp[red[0] - dx[dir]][red[1] - dy[dir]];
                    temp[red[0] - dx[dir]][red[1] - dy[dir]] = temp[red[0]][red[1]];
                    temp[red[0]][red[1]] = tp;
                    move = true;
                } else if (temp[red[0]][red[1]] == 'O') {
                    success = 1;
                    redEnd = false;
                    temp[red[0] - dx[dir]][red[1] - dy[dir]] = '.';
                } else {
                    red[0] -= dx[dir];
                    red[1] -= dy[dir];
                }
            }

            if (blue[0] + dx[dir] > 0 &&
                    blue[1] + dy[dir] > 0 &&
                    blue[0] + dx[dir] < n - 1 &&
                    blue[1] + dy[dir] < m - 1) {
                blue[0] += dx[dir];
                blue[1] += dy[dir];
                if (temp[blue[0]][blue[1]] == '.') {
                    char tp = temp[blue[0] - dx[dir]][blue[1] - dy[dir]];
                    temp[blue[0] - dx[dir]][blue[1] - dy[dir]] = temp[blue[0]][blue[1]];
                    temp[blue[0]][blue[1]] = tp;
                    move = true;
                } else if (temp[blue[0]][blue[1]] == 'O') {
                    success = -1;
                    break;
                } else {
                    blue[0] -= dx[dir];
                    blue[1] -= dy[dir];
                }
            }

            if (!move) {
                if (!redEnd) {
                    break;
                }
                success = 0;
                break;
            }
        }
        return temp;
    }
}
