
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                int k = i;
                while (k <= n) {
                    arr[k] = 1 - arr[k];
                    k += i;
                }
            }
            int cnt = 0;
            for (int i = 1; i <=n;i++) {
                if(arr[i] == 1) {
                    cnt++;
                }
            }
            sb.append(cnt);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
