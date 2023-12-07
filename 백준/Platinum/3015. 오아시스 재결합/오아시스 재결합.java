
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long sum = 0;

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            int cnt = 1;
            while(!dq.isEmpty() && dq.peekLast()[0] <= h) {
                if(dq.peekLast()[0] == h) {
                    cnt += dq.peekLast()[1];
                }
                sum += dq.pollLast()[1];
            }

            if(!dq.isEmpty()) {
                sum++;
            }
            dq.addLast(new int[]{h, cnt});
        }
        System.out.println(sum);
    }
}
