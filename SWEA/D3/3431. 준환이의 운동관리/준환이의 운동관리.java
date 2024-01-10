import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int T, L, U, X;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            sb.append("#");
            sb.append(i);
            sb.append(" ");
            String[] line = br.readLine().split(" ");
            L = Integer.parseInt(line[0]);
            U = Integer.parseInt(line[1]);
            X = Integer.parseInt(line[2]);

            if(X > U) {
                sb.append(-1);
            } else if(X < L) {
                sb.append(L - X);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
