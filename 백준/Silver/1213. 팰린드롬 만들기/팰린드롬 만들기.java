
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        int[] dp = new int[26];
        for (char c : charArray) {
            dp[c-'A']++;
        }
        boolean mid = false;
        char midCh = '0';
        for (int i  = 0; i < 26; i++) {
            if(dp[i] % 2 == 1) {
                if(mid) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                } else {
                    midCh = (char)('A' + i);
                    mid = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i  = 0; i < 26; i++) {
            for (int j = 0; j < dp[i] / 2;j++) {
                sb.append((char)('A' + i));
            }
        }
        if(!mid) {
            System.out.println(sb.toString() + sb.reverse().toString());
        } else {
            System.out.println(sb.toString() + midCh + sb.reverse().toString());
        }
    }

}
