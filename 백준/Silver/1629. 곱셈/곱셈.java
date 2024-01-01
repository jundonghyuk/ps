
import java.util.Scanner;

public class Main {

    static long[] dp = new long[200];
    static long a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        if (a == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(rec(b));
    }

    public static long rec(long target) {
        if (target == 1) {
            return a % c;
        }
        long half = rec(target / 2) % c;
        long value = half * half % c;
        if (target % 2 == 0) {
            return value % c;
        } else {
            return (value * a) % c;
        }
    }
}
