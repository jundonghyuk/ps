
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        Deque<Character> dq = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String line = br.readLine();
            dq.clear();
            boolean yes = true;
            if(line.equals(".")) {
                return;
            }

            for (char ch : line.toCharArray()) {
                if(ch == '(' || ch == '[') {
                    dq.addLast(ch);
                    continue;
                }
                if(ch == ')') {
                    if(!dq.isEmpty() && dq.pollLast() == '(') {
                        continue;
                    } else {
                        yes = false;
                        break;
                    }
                }
                if(ch == ']') {
                    if(!dq.isEmpty() && dq.pollLast() == '[') {
                        continue;
                    } else {
                        yes = false;
                        break;
                    }
                }
            }
            if(!dq.isEmpty()) {
                System.out.println("no");
                continue;
            }
            if(yes) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
