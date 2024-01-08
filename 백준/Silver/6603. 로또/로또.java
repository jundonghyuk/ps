
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] arr, ret;
    static StringBuilder sb;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            N = sc.nextInt();
            if (N == 0) {
                break;
            }
            arr = new int[N];
            ret = new int[N];
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            rec(0, 0);
            System.out.println(sb);
        }
    }

    public static void rec(int depth, int next) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(ret[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = next; i < N; i++) {
            ret[depth] = arr[i];
            rec(depth + 1, i + 1);
        }
    }
}
