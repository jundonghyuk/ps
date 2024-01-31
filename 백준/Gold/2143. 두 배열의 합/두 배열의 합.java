
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int t, n, m;
    static int[] arr1, arr2;
    static int[] sum1, sum2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        n = sc.nextInt();
        arr1 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr1[i] = sc.nextInt() + arr1[i - 1];
        }
        m = sc.nextInt();
        arr2 = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            arr2[i] = sc.nextInt() + arr2[i - 1];
        }

        int sum1Len = n * (n + 1) / 2;
        int sum2Len = m * (m + 1) / 2;
        sum1 = new int[sum1Len];
        sum2 = new int[sum2Len];

        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                sum1[cnt] = arr1[j] - arr1[i];
                cnt++;
            }
        }
        Arrays.sort(sum1);

        cnt = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = i + 1; j <= m; j++) {
                sum2[cnt] = arr2[j] - arr2[i];
                cnt++;
            }
        }
        Arrays.sort(sum2);

        int st = 0;
        int en = sum2Len - 1;
        long ret = 0;
        while (st < sum1Len && en >= 0) {
            if (sum1[st] + sum2[en] > t) {
                en--;
            } else if (sum1[st] + sum2[en] < t) {
                st++;
            } else {
                long sum1Cnt = 1;
                int prev1 = sum1[st];
                while (st < sum1Len - 1 && sum1[st + 1] == prev1) {
                    st++;
                    sum1Cnt++;
                }
                st++;

                long sum2Cnt = 1;
                int prev2 = sum2[en];
                while (en > 0 && sum2[en - 1] == prev2) {
                    en--;
                    sum2Cnt++;
                }
                en--;
                ret += sum1Cnt * sum2Cnt;
            }
        }
        System.out.println(ret);
    }
}
