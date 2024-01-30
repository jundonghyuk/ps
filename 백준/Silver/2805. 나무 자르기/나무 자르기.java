
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int m, n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int l = 0;
        int r = arr[n - 1];
        while (l + 1 < r) {
            int mid = (l + r) / 2;

            if (check(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println(l);
    }

    public static boolean check(int height) {
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += Math.max(arr[i] - height, 0);
        }
        if (cnt >= m) {
            return true;
        }
        return false;
    }
}
