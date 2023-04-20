import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int maxB = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            maxB = Math.max(arr[i], maxB);
        }

        int l = maxB;
        int r = sum;

        while (l <= r) {
            int mid = (l + r) / 2;
            int partSum = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                partSum += arr[i];
                if (partSum > mid) {
                    cnt++;
                    partSum = arr[i];
                }
            }
            if (partSum != 0) {
                cnt++;
            }
            if (cnt > M) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);

    }
}
