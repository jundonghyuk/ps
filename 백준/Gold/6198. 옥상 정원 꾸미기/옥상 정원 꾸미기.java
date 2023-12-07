

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
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(br.readLine());
            if(dq.isEmpty()) {
                dq.addLast(new int[]{height, i});
                continue;
            }

            while(!dq.isEmpty() && dq.peekLast()[0] <= height) {
                sum += (i-1) - dq.pollLast()[1];
            }
            dq.addLast(new int[]{height, i});
        }
        while(!dq.isEmpty()) {
            sum += N - dq.pollLast()[1];
        }
        System.out.println(sum);
    }
}
