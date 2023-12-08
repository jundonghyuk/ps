
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();
        while(N-- > 0) {
            String command = br.readLine();
            if(command.startsWith("push")) {
                q.addLast(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.pollFirst());
                }
            } else if (command.equals("size")) {
                System.out.println(q.size());
            } else if (command.equals("front")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekFirst());
                }
            } else if (command.equals("back")) {
                if(q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekLast());
                }
            } else if(command.equals("empty")) {
                if(q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }

    }
}
