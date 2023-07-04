import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static boolean[] usedNumber;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        usedNumber = new boolean[10];
        answer = new int[10];
        
        backTracking(0);

    }

    static void backTracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            if (usedNumber[i]) {
                continue;
            }
            answer[depth] = i;
            usedNumber[i] = true;
            backTracking(depth + 1);
            usedNumber[i] = false;
        }
    }
}
