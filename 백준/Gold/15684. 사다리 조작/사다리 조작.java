
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
        10:44 ~
        10 * 30 = 300
        300 *300 * 300 = 27000000 /6 = 450만
 */
public class Main {
    static int n, m, h;
    static boolean[][] ladder;
    static List<int[]> candi = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        ladder = new boolean[h][n];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            ladder[a][b] = true;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (j == 0) {
                    if (!ladder[i][j] && !ladder[i][j + 1]) {
                        candi.add(new int[]{i, j});
                    }
                } else {
                    if (!ladder[i][j] && !ladder[i][j - 1] && !ladder[i][j + 1]) {
                        candi.add(new int[]{i, j});
                    }
                }
            }
        }
        if (check()) {
            System.out.println(0);
            return;
        }

        int size = candi.size();
        int ret = 5;
        for (int i = 0; i < size; i++) {
            int[] location = candi.get(i);
            ladder[location[0]][location[1]] = true;
            if (check()) {
                System.out.println(1);
                return;
            }

            for (int j = i + 1; j < size; j++) {
                int[] location_2 = candi.get(j);
                int x = location_2[0];
                int y = location_2[1];
                if (y == n) {
                    if (ladder[x][y - 1]) continue;
                } else if (y == 0) {
                    if (ladder[x][y + 1]) continue;
                } else {
                    if (ladder[x][y - 1] || ladder[x][y + 1]) continue;
                }
                ladder[location_2[0]][location_2[1]] = true;

                if (check()) {
                    ret = 2;
                }

                for (int k = j + 1; k < size; k++) {
                    int[] location_3 = candi.get(k);

                    x = location_3[0];
                    y = location_3[1];
                    if (y == n) {
                        if (ladder[x][y - 1]) continue;
                    } else if (y == 0) {
                        if (ladder[x][y + 1]) continue;
                    } else {
                        if (ladder[x][y - 1] || ladder[x][y + 1]) continue;
                    }

                    ladder[location_3[0]][location_3[1]] = true;
                    if (check()) {
                        ret = Math.min(ret, 3);
                    }
                    ladder[location_3[0]][location_3[1]] = false;
                }

                ladder[location_2[0]][location_2[1]] = false;
            }
            ladder[location[0]][location[1]] = false;
        }
        if (ret <= 3) {
            System.out.println(ret);
            return;
        }
        System.out.println(-1);
    }

    public static boolean check() {
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print((ladder[i][j] ? 1 : 0) + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = 0; j < h; j++) {
                if (idx == 0) {
                    if (ladder[j][idx]) {
                        idx++;
                    }
                } else if (idx == n - 1) {
                    if (ladder[j][idx - 1]) {
                        idx--;
                    }
                } else {
                    if (ladder[j][idx]) {
                        idx++;
                    } else if (ladder[j][idx - 1]) {
                        idx--;
                    }
                }
            }
            if (idx != i) {
                return false;
            }
        }
        return true;
    }
}
