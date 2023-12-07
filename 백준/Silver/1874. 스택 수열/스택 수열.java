
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Deque<Integer> left = new ArrayDeque<>();
    static Deque<Integer> right = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = N; i > 0; i--) {
            right.addLast(i);
        }
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            while (!right.isEmpty() && num >= right.peekLast()) {
                left.addLast(right.pollLast());
                sb.append("+\n");
            }
            
            if(left.peekLast() == num) {
                left.pollLast();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
