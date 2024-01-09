
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

        5:50 ~
        1. 살릴 치킨집 선택 M개 -> MAX = 13C6 = 1716
        2. 각집에서 치킨거리 계산 -> 100 * 13 = 1300..

 */
public class Main {

    static int N, M;
    static int ret = Integer.MAX_VALUE;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static int[] chickenIdx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        chickenIdx = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                if (num == 1) {
                    houses.add(new int[]{i, j});
                } else if (num == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        selectChickenStore(0, 0);
        System.out.println(ret);
    }

    public static void selectChickenStore(int depth, int cur) {
        if (depth == M) {
            calculate();
            return;
        }

        for (int i = cur; i < chickens.size(); i++) {
            chickenIdx[depth] = i;
            selectChickenStore(depth + 1, i + 1);
        }
    }

    public static void calculate() {
        int sum = 0;
        for (int[] house : houses) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < M; i++) {
                int[] location = chickens.get(chickenIdx[i]);
                min = Math.min(min, Math.abs(house[0] - location[0]) + Math.abs(house[1] - location[1]));
            }
            sum += min;
        }
        ret = Math.min(sum, ret);
    }
}
