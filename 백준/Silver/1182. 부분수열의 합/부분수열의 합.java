
import java.util.Scanner;

public class Main {

    static int N, S, ret;
    static int[] nums = new int[21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        rec(0, 0, false);
        System.out.println(ret);
    }

    public static void rec(int depth, int val, boolean choice) {
        if (depth == N) {
            if (val == S && choice) {
                ret++;
            }
            return;
        }
        rec(depth + 1, val + nums[depth], true);
        rec(depth + 1, val, choice);
    }
}
