
import java.util.Arrays;
import java.util.Scanner;

/*
    3:35 ~
 */
public class Main {
    static int t, n;
    static int[] money;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            money = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                money[i] = sc.nextInt();
            }
            int max = money[n-1];

            for (int i = n -2; i >= 0; i--) {
                if(max < money[i]) {
                    max = money[i];
                }
                sum += (max - money[i]);
            }
            System.out.println(sum);
        }
    }
}
