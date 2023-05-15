import java.util.Scanner;

public class Main {
    static int[] std;
    static int[] L;
    static int[] R;
    static int MAX_NUM = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        std = new int[N];
        L = new int[N];
        R = new int[N];

        for (int i = 0; i < N; i++) {
            std[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                L[i] = std[i];
                MAX_NUM = Math.max(MAX_NUM, L[i]);
                continue;
            }

            if (L[i - 1] < 0) {
                L[i] = std[i];
            } else {
                L[i] = std[i] + L[i - 1];
            }

            MAX_NUM = Math.max(MAX_NUM, L[i]);
        }

        for (int i = N - 1; i >= 0; i--) {
            if (i == N - 1) {
                R[i] = std[i];
                continue;
            }
            if (R[i + 1] < 0) {
                R[i] = std[i];
            } else {
                R[i] = std[i] + R[i + 1];
            }
        }

        for (int i = 1; i < N - 1; i++) {
            if (L[i - 1] + R[i + 1] > MAX_NUM) {
                MAX_NUM = L[i - 1] + R[i + 1];
            }
        }

        System.out.println(MAX_NUM);
    }
}
