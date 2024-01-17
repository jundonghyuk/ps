
import java.util.Scanner;

/*
        3:22 ~

 */
public class Main {

    static int n;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            arr[1][0] += arr[0][1];
            arr[1][1] += Math.min(arr[1][0], Math.min(arr[0][1], arr[0][1] + arr[0][2]));
            arr[1][2] += Math.min(arr[1][1], Math.min(arr[0][1], arr[0][1] + arr[0][2]));


            for (int i = 2; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    int min = arr[i - 1][j];

                    if (j != 0) {
                        min = Math.min(min, arr[i - 1][j - 1]);
                        min = Math.min(min, arr[i][j - 1]);
                    }
                    if (j != 2) {
                        min = Math.min(min, arr[i - 1][j + 1]);
                    }
                    arr[i][j] += min;
                }
            }
            System.out.println(t + ". " + arr[n - 1][1]);
            t++;
        }
    }
}
