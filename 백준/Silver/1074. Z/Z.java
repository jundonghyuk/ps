
import java.util.Scanner;

public class Main {
    static long N, R, C;
    static long ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        R = sc.nextLong();
        C = sc.nextLong();
        System.out.println(rec(N, R, C) - 1);
    }

    public static long rec(long n, long r, long c) {
        if (n == 1) {
            if (r == 0 && c == 0) {
                return 1;
            } else if (r == 0 && c == 1) {
                return 2;
            } else if (r == 1 && c == 0) {
                return 3;
            }
            return 4;
        }
        long boundary = (long) Math.pow(2, n - 1);
        if (r < boundary) {
            if (c < boundary) {
                return rec(n - 1, r, c);
            } else {
                return boundary * boundary + rec(n - 1, r, c - boundary);
            }
        } else {
            if (c < boundary) {
                return 2 * boundary * boundary + rec(n - 1, r - boundary, c);
            } else {
                return 3 * boundary * boundary + rec(n - 1, r - boundary, c - boundary);
            }
        }
    }
}
