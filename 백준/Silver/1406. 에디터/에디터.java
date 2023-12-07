
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static String text;
    static int N;
    static Deque<Character> left = new ArrayDeque<>();
    static Deque<Character> right = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();
        for (char ch : text.toCharArray()) {
            left.addLast(ch);
        }
        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            String command = br.readLine();
            if(command.startsWith("P")) {
                left.add(command.toCharArray()[2]);
            } else if(command.equals("L") && !left.isEmpty()) {
                right.addLast(left.pollLast());
            } else if(command.equals("D") && !right.isEmpty()) {
                left.addLast(right.pollLast());
            } else if(command.equals("B") && !left.isEmpty()) {
                left.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }
        while(!right.isEmpty()) {
            sb.append(right.pollLast());
        }
        System.out.println(sb);
    }
}
