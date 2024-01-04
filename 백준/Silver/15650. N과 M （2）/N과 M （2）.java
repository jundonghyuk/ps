
import java.util.Scanner;

public class Main {

    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        rec(0, "", 0);
    }


    public static void rec(int depth, String s, int prev) {
        if(depth == M) {
            System.out.println(s);
            return;
        }

        for (int i = prev + 1; i <= N; i++) {
            rec(depth + 1, s + i + " ", i);
        }
    }
}
