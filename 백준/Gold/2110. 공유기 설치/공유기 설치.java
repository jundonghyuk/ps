
import java.util.Arrays;
import java.util.Scanner;

/*
        check: len 이상의 거리를 벌리면서 공유기를 c개 설치할 수있는가?
 */
public class Main {
    static int n, c;
    static int[] arr;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (check(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        System.out.println(lo);
    }

    public static boolean check(int len) {
        int cnt = 1;
        int pos = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - pos >= len) {
                cnt++;
                pos = arr[i];
            }
        }
        /*
                cnt가 더 많으면 거리를 더 벌릴 수 있다는 뜻
         */
        return cnt >= c;
    }
}
