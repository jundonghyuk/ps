
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] nArr;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nArr = new int[n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }
        Arrays.sort(nArr);
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;

                if (nArr[mid] > k) {
                    r = mid - 1;
                } else if (nArr[mid] < k) {
                    l = mid + 1;
                } else {
                    check[mid] = true;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(!check[i]) {
                sb.append(nArr[i] + " ");
                cnt++;
            }
        }
        System.out.println(cnt);
        if(cnt != 0) {
            System.out.println(sb);
        }
    }
}
