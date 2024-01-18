
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
9:09 ~

            0  -1
            1  0
 */
public class Main {
    static boolean[][] board = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            List<int[]> list = new ArrayList<>();
            list.add(new int[]{x, y});
            list.add(new int[]{x + dx[d], y + dy[d]});
            for (int gener = 0; gener < g; gener++) {
                int size = list.size();
                int[] c = list.get(size - 1);
                for (int i = size-1; i >= 0; i--) {
                    list.add(rotate(c[0], c[1], list.get(i)[0], list.get(i)[1]));
                }
            }
            for (int i = 0; i < list.size(); i++) {
                int[] loc = list.get(i);
//                System.out.println(loc[0] + " " + loc[1]);
                board[loc[0]][loc[1]] = true;
            }
        }

//        int[] rot = rotate(2, 4, 1, -1);
//        System.out.println(rot[0]);
//        System.out.println(rot[1]);
        int ret = 0;
        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                if (board[i][j] &&
                        board[i][j + 1] &&
                        board[i + 1][j] && board[i + 1][j + 1]) {
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }

    public static int[] rotate(int cx, int cy, int tx, int ty) {
        int centerX = cx;
        int centerY = cy;
        tx -= centerX;
        ty -= centerY;
        int temp = ty;
        ty = tx;
        tx = -temp;
        tx += cx;
        ty += cy;
        return new int[]{tx, ty};
    }
}
