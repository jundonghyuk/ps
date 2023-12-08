
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ret = 0;
        while(N-- > 0) {
            Deque<Character> dq = new ArrayDeque<>();
            String line = br.readLine();
            for (char ch : line.toCharArray()) {
                if(dq.isEmpty()) {
                    dq.addLast(ch);
                    continue;
                }

                if(ch == dq.peekLast()) {
                    dq.pollLast();
                } else {
                    dq.addLast(ch);
                }
            }
            if(dq.isEmpty()) {
                ret++;
            }
        }
        System.out.println(ret);
    }
}
