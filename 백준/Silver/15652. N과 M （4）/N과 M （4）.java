import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] arr = new int[10];
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr[0] = 1;
        rec(1);
        System.out.println(sb);
    }


    public static void rec(int depth) {
        if(depth == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = arr[depth - 1]; i <= N; i++) {
            arr[depth] = i;
            rec(depth + 1);
            arr[depth] = 0;
        }
    }
}
