
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] nums = new int[2000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            nums[Integer.parseInt(st.nextToken())]++;
        }
        int X = Integer.parseInt(br.readLine());

        int ret = 0;
        for (int i = 1; i <= (X - 1) / 2; i++) {
            ret += nums[i] * nums[X - i];
        }

        if (X % 2 == 0) {
            ret += nums[X / 2] * (nums[X / 2] - 1) / 2;
        }
        System.out.println(ret);
    }
}
