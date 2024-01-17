
import java.util.Scanner;

/*
        5:43~
 */
public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int score = arr[n - 1];
        int ret = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= score) {
                int origin = arr[i];
                int change = score - 1;
                ret += (origin - change);
                arr[i] = change;
            }
            score = arr[i];
        }
        System.out.println(ret);
    }
}
