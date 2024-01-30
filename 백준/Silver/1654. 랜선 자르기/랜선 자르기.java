
import java.lang.reflect.Array;
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

        long l = 1;
        long r = Arrays.stream(arr).max().getAsLong();
        long ret = 0 ;
        while(l <= r) {
            long mid = (l + r) / 2;
            if(check(arr, mid) >= m) {
                ret = Math.max(ret, mid);
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        System.out.println(ret);
    }

    public static long check(long[] arr, long len) {
        long cnt = 0;
        for (long num : arr) {
            cnt += (num / len);
        }
        return  cnt;
    }
}
