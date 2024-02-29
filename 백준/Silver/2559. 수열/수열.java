import java.io.*;
import java.util.*;

public class Main{
    
    static int n, k;
	static int[] nums;
    static int[] dp;
    
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nums = new int[n + 1];
		dp = new int[n + 1];
		st = new StringTokenizer(br.readLine()," ");
        
		for(int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = dp[i-1] + nums[i];
		}
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            max = Math.max(max, dp[i + k] - dp[i]);
        }
		System.out.println(max);
	}
}