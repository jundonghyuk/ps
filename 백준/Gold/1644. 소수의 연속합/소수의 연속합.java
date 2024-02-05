
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean[] prime = new boolean[4000001];
    static int n;

    public static void main(String[] args) {
        Arrays.fill(prime, true);
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        prime[1] = false;
        eratos();
        int left = 2;
        int right = 2;
        long tot = 2;
        int ret = 0;
        for (left = 2; left <= n; left++) {
            if (!isPrime(left)) {
                continue;
            }
            while (tot < n) {
                right++;
                if (right >= n + 1) {
                    break;
                }
                if (!prime[right]) {
                    continue;
                }
                tot += right;
            }
            if (right >= n + 1) {
                break;
            }
            if(tot == n) {
                ret++;
            }
            tot -= left;
        }
        System.out.println(ret);
    }

    public static void eratos() {
        for (int i = 2; i <= n; i++) {
            if (!isPrime(i)) {
                for (int j = i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    public static boolean isPrime(int num) {

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
