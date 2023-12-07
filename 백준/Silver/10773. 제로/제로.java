
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long sum = 0;
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sum -= dq.pollLast();
            } else {
                sum += num;
                dq.addLast(num);
            }
        }
        System.out.println(sum);
    }
}
