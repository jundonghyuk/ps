
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    static int K;
    static int cnt = 0;
    static StringJoiner sj = new StringJoiner("\n");
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        hanoi(K, 1, 3);
        System.out.println(cnt);
        System.out.println(sj);
    }

    public static void hanoi(int step, int cur, int next) {
        cnt++;
        if (step == 1) {
            sj.add(cur +" " + next);
            return;
        }
        hanoi(step-1, cur, 6-cur-next);
        sj.add(cur +" " + next);
        hanoi(step-1, 6-cur-next, next);
    }
}
