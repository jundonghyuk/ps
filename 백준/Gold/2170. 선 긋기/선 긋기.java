
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
        1:23 ~
 */
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lines = new int[n][2];
        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken()) + 1000000000;
            lines[i][1] = Integer.parseInt(st.nextToken()) + 1000000000;
        }
        Arrays.sort(lines, (o1, o2) -> {
            return o1[0] != -o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
        });
        int st = lines[0][0];
        int en = lines[0][1];
        int ret = en - st;
        for (int i = 1; i < lines.length; i++) {
            int[] next =lines[i];
            if(next[0] <= en && next[1] > en) {
                ret += (next[1] - en);
                en = next[1];
                continue;
            }
            if(next[0] > en) {
                st = next[0];
                en = next[1];
                ret += (en - st);
            }
        }
        System.out.println(ret);
    }
}
