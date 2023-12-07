import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N;
    static Deque<String> left = new ArrayDeque<>();
    static Deque<String> right = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            left = new ArrayDeque<>();
            right = new ArrayDeque<>();
            String commands = br.readLine();
            for (String command : commands.split("")) {

                if (command.equals("<")) {
                    if (left.isEmpty()) continue;
                    right.addLast(left.pollLast());
                } else if (command.equals(">")) {
                    if (right.isEmpty()) continue;
                    left.addLast(right.pollLast());
                } else if (command.equals("-")) {
                    if (left.isEmpty()) continue;
                    left.pollLast();
                } else {
                    left.addLast(command);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) {
                sb.append(left.pollFirst());
            }
            while (!right.isEmpty()) {
                sb.append(right.pollLast());
            }
            System.out.println(sb);
        }
    }
}
