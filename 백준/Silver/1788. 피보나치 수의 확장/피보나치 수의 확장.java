
import java.util.Scanner;

public class Main {

    static long[] pFibo = new long[1000001];
    static long[] nFibo = new long[1000001];
    static long mod = 1000000000;

    public static void main(String[] args) {

        int n = new Scanner(System.in).nextInt();
        pFibo[1] = 1;
        nFibo[1] = 1;
        if (n > 0) {
            for (int i = 2; i <= n; i++) {
                pFibo[i] = (pFibo[i - 1] + pFibo[i - 2]) % mod;
            }
            System.out.println(1);
            System.out.println(pFibo[n]);
        } else if (n < 0) {
            n = -n;
            for (int i = 2; i <= n; i++) {
                nFibo[i] = (nFibo[i - 2] - nFibo[i - 1]) %mod;
            }
            System.out.println(nFibo[n] < 0 ? -1 : (nFibo[n] == 0 ? 0 : 1));
            System.out.println(Math.abs(nFibo[n]) % mod);
        } else {
            System.out.println(0);
            System.out.println(0);
        }
    }
}
