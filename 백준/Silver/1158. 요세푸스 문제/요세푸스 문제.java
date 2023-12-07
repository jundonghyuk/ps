
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {

    static int N, K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        StringJoiner sj = new StringJoiner(", ");

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }
        int count = 1;
        while (!dq.isEmpty()) {
            if (count % K == 0) {
                sj.add(String.valueOf(dq.pollFirst()));
            } else {
                dq.addLast(dq.pollFirst());
            }
            count++;
        }

        System.out.println("<" + sj.toString() + ">");
    }
}
