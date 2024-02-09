
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            n = Math.min(n, m - n);

            long ret = 1;
            for (int i = m; i> m-n; i--) {
                ret *= i;
            }
            for (int i = 1; i <= n; i++) {
                ret /= i;
            }

            System.out.println(ret);
        }
    }
}
