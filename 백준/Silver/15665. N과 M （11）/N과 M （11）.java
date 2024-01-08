
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[] ret = new int[10];
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        nm(0);
        System.out.println(sb);
    }

    public static void nm(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ret[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        int temp = -1;
        for (int i = 0; i < N; i++) {
            if(temp == arr[i]) {
                continue;
            }
            temp = arr[i];
            ret[depth] = arr[i];
            nm(depth+1);
        }
    }
}
