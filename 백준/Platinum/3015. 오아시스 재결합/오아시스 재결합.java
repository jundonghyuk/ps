
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
            if(!dq.isEmpty() && dq.peekLast()[0] > h) {
                sum++;
                dq.addLast(new int[]{h, 1});
            } else if(!dq.isEmpty() && dq.peekLast()[0] < h) {
                while(!dq.isEmpty() && dq.peekLast()[0] < h) {
                    sum++;
                    dq.pollLast();
                }
                if(dq.isEmpty()) {
                    dq.addLast(new int[]{h, 1});
                } else {
                    if(dq.peekLast()[0] == h) {
                        sum += dq.size() == dq.peekLast()[1] ? dq.peekLast()[1] : dq.peekLast()[1] + 1;
                        dq.addLast(new int[]{h, dq.peekLast()[1] + 1});
                    } else {
                        sum++;
                        dq.addLast(new int[]{h, 1});
                    }
                }
            } else if (!dq.isEmpty() && dq.peekLast()[0] == h) {
                sum += dq.size() == dq.peekLast()[1] ? dq.peekLast()[1] : dq.peekLast()[1] + 1;
                dq.addLast(new int[]{h, dq.peekLast()[1] + 1});
            } else {
                dq.addLast(new int[]{h, 1});
            }
//            System.out.println(sum);
        }
        System.out.println(sum);
    }
}
