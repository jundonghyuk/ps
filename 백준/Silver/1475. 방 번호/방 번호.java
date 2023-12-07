import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] nums = new int[10];
        while (N > 0) {
            nums[N % 10]++;
            N /= 10;
        }

        int min = 1;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            min = Math.max(nums[i], min);
        }
        min = Math.max((nums[6] + nums[9] + 1) / 2, min);
        System.out.println(min);
    }
}
