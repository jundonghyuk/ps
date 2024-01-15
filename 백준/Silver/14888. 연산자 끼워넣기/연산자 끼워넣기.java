
import java.util.Scanner;

/*
    11:52~
 */
public class Main {

    static int n;
    static int[] operator = new int[4];
    static int[] arr = new int[12];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int temp = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        temp = arr[0];
        rec(1, temp);
        System.out.println(max);
        System.out.println(min);
    }

    public static void rec(int depth, int num) {
        if (depth == n) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;
            operator[i]--;
            if (i == 0) {
                rec(depth + 1, num + arr[depth]);
            } else if (i == 1) {
                rec(depth + 1, num - arr[depth]);
            } else if (i == 2) {
                rec(depth + 1, num * arr[depth]);
            } else {
                if (num < 0) {
                    rec(depth + 1, -((-num) / arr[depth]));
                } else {
                    rec(depth + 1, num / arr[depth]);
                }
            }
            operator[i]++;
        }
    }
}
