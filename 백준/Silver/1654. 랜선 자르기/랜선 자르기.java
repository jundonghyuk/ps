
import java.util.Arrays;
import java.util.Scanner;

/*
    5:21 ~
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long lo = 1;
        long hi = Arrays.stream(arr).max().getAsLong() + 1;
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            if (check(arr, mid, m)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        System.out.println(lo);
    }

    public static boolean check(long[] arr, long len, long m) {
        long cnt = 0;
        for (long num : arr) {
            cnt += (num / len);
        }
        if (cnt >= m) {
            return true;
        }
        return false;
    }
}
