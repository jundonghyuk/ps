
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ret = Integer.MAX_VALUE;
        int l = -1;
        int r = -1;
        int en = n - 1;
        for (int st = 0; st < en; st++) {
            while (st < en && arr[en] + arr[st] > 0) {
                int num = arr[en] + arr[st];
                if (Math.abs(num) < Math.abs(ret)) {
                    ret = num;
                    l = arr[st];
                    r = arr[en];
                }
                en--;
            }
            if(st == en) {
                break;
            }
            int num = arr[en] + arr[st];
            if (Math.abs(num) < Math.abs(ret)) {
                ret = num;
                l = arr[st];
                r = arr[en];
            }
        }
        System.out.println(ret);
    }
}
