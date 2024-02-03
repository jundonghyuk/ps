
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr;
    static int[] used = new int[100001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        k = Integer.parseInt(st1.nextToken());
        arr = new int[n];
        st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        int st =0;
        int en = 0;
        int ret = 0;
        for (st = 0; st < n; st++) {
            int num = arr[st];
            if(used[num] + 1 > k) {
                while(en < st) {
                    used[arr[en]]--;
                    if(arr[en] == num) {
                        en++;
                        break;
                    }
                    en++;
                }
            }
            used[num]++;
            ret = Math.max(ret, st - en + 1);
        }
        System.out.println(ret);
    }
}
