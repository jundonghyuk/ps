
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] arr;
    static int[] ret = new int[10];
    static boolean[] select = new boolean[10];
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        rec(0);
        System.out.println(sb);
    }


    public static void rec(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ret[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(select[i]) {
                continue;
            }
            ret[depth] = arr[i];
            select[i] = true;
            rec(depth + 1);
            select[i] = false;
        }

    }
}
