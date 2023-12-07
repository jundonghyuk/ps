
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        while (N-- > 0) {
            String command = br.readLine();
            if (command.startsWith("push")) {
                push(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("top")) {
                top();
            } else if (command.equals("size")) {
                size();
            } else if (command.equals("empty")) {
                empty();
            } else if (command.equals("pop")) {
                pop();
            }
        }
    }

    public static void top() {
        int num = dq.isEmpty() ? -1 : dq.peekLast();
        System.out.println(num);
    }

    public static void size() {
        int num = dq.size();
        System.out.println(num);
    }

    public static void pop() {
        int num = dq.isEmpty() ? -1 : dq.pollLast();
        System.out.println(num);
    }

    public static void empty() {
        int num = dq.isEmpty() ? 1 : 0;
        System.out.println(num);
    }

    public static void push(int num) {
        dq.addLast(num);
    }
}
