
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Deque<Character> dq = new ArrayDeque<>();
        int ret = 0;
        char previous = '(';
        for (char ch : line.toCharArray()) {
            if(ch == '(') {
                dq.addLast('(');
                previous = '(';
                continue;
            }

            dq.pollLast();
            if (previous == '(') {
                ret += dq.size();
                previous = ')';
                continue;
            }
            ret++;
        }
        System.out.println(ret);
    }
}
