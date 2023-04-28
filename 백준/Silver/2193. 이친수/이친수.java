import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[N+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(recursiveDp(N));
    }
    
    
    static long recursiveDp(int n) {
        if(dp[n] != -1) {
            return dp[n];
        } 
        
        dp[n] = recursiveDp(n-1) + recursiveDp(n-2);
        return dp[n];
    }
}
