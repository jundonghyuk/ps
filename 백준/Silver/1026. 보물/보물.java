
import java.util.Arrays;
import java.util.Scanner;

/*
        6:56 ~
 */
public class Main {

    static int n;
    static long ret;
    static long[] a;
    static long[] b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new long[n];
        b = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            ret += a[i] * b[n - i - 1];
        }
        System.out.println(ret);
    }
}
