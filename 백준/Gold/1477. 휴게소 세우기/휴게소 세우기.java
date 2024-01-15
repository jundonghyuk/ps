
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m, l;
    static int[] arr;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();
        arr = new int[n + 2];
        dist = new int[n + 1];
        arr[0] = 0;
        arr[n + 1] = l;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 2; i++) {
            dist[i - 1] = arr[i] - arr[i - 1];
            min = Math.min(min, dist[i - 1]);
            max = Math.max(max, dist[i - 1]);
        }

        int left = 1;
        int right = max;
        while (left <= right) {
            int cnt = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < dist.length; i++) {
                cnt += (dist[i] -1) / mid;
            }
            if(cnt > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
