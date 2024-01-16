
import java.util.Arrays;
import java.util.Scanner;

/*
        2:43
 */
public class Main {

    static int n;
    static int[][] flowers;
    static int[][] calender = new int[13][32];
    static int start, end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        flowers = new int[n][2];
        calculate();
        for (int i = 0; i < n; i++) {
            int sm = sc.nextInt();
            int sd = sc.nextInt();
            int em = sc.nextInt();
            int ed = sc.nextInt();
            flowers[i][0] = calender[sm][sd];
            flowers[i][1] = calender[em][ed];
        }
        start = calender[3][1];
        end = calender[11][30];

        Arrays.sort(flowers, (f1, f2) -> {
            if (f1[0] < f2[0]) {
                return -1;
            } else if (f1[0] == f2[0]) {
                return f2[1] - f1[1];
            } else {
                return 1;
            }
        });

        boolean find = false;
        int nextStart = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int[] flower = flowers[i];
//            System.out.println(i +" " + flower[0] + " " + flower[1] + " " +start);
            // 다음 꽃이 피는 날이 진 날 보다 크면
            if (flower[0] <= start) {
                find = true;
                nextStart = Math.max(nextStart, flower[1]);
            } else {
                if (find) {
                    ret++;
                    start = nextStart;
                    find = false;
                    i--;
                    if(nextStart > end) {
                        System.out.println(ret);
                        return;
                    }
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }
        if(find) {
            ret++;
            start = nextStart;
            if(nextStart > end) {
                System.out.println(ret);
                return;
            }
        }
        System.out.println(0);
    }

    public static void calculate() {
        int cnt = 1;
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 31; j++) {
                if (i == 2 && j == 29) continue;
                if ((i == 4 || i == 6 || i == 9 || i == 11) && j == 31) continue;
                calender[i][j] = cnt;
                cnt++;
            }
        }
    }
}
