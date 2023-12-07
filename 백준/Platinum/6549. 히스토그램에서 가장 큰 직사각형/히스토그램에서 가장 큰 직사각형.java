
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                return;
            }

            // height, index
            Deque<int[]> dq = new ArrayDeque<>();
            long max = 0;
            /*
                    1.
             */
            for (int i = 0; i < N; i++) {
                int h = Integer.parseInt(st.nextToken());
                int w = i;
                while(!dq.isEmpty() && dq.peekLast()[0] > h) {
                    int[] stick = dq.pollLast();
                    int width = i - stick[1];
                    int height = stick[0];
                    w = stick[1];
                    max = Math.max(max, (long) height * width);
                }
                dq.add(new int[]{h, w});
            }

            while(!dq.isEmpty()) {
                int[] stick = dq.pollLast();
                int width = N - stick[1];
                int height = stick[0];
                max = Math.max(max, (long) height * width);
            }
            System.out.println(max);
        }
    }
}
