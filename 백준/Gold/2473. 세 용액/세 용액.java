
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static long[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long l = -1;
        long m = -1;
        long r = -1;
        long zero = Long.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int st = i + 1;
            int en = n - 1;
            while (st < en) {
                if (Math.abs(arr[st] + arr[en] + arr[i]) < Math.abs(zero)) {
                    l = arr[i];
                    m = arr[st];
                    r = arr[en];
                    zero = l + m + r;
                }
                if (arr[st] + arr[en] + arr[i] < 0) {
                    st++;
                } else {
                    en--;
                }
            }
        }
        System.out.println(l + " " + m + " " + r);
    }
}
