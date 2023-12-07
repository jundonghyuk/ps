
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long sum = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(br.readLine());
            while(!dq.isEmpty() && dq.peekLast() <= height) {
                dq.pollLast();
            }
            sum += dq.size();
            dq.addLast(height);
        }
        System.out.println(sum);
    }
}
