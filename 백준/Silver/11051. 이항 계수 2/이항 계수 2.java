
import java.util.Scanner;

public class Main {

    static int[][] comb = new int[1001][1001];
    static int mod = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= 1000; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % mod;
            }
        }
        System.out.println(comb[n][k]);
    }
}
