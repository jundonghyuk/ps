
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringJoiner sj = new StringJoiner("\n");
        Deque<Integer> q = new LinkedList<>();
        while(N-- > 0) {
            String command = br.readLine();
            if(command.startsWith("push")) {
                q.addLast(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop")) {
                if(q.isEmpty()) {
                    sj.add("-1");
                } else {
                    sj.add(String.valueOf(q.pollFirst()));
                }
            } else if (command.equals("size")) {
                sj.add(String.valueOf(q.size()));
            } else if (command.equals("front")) {
                if(q.isEmpty()) {
                    sj.add("-1");
                } else {
                    sj.add(String.valueOf(q.peekFirst()));
                }
            } else if (command.equals("back")) {
                if(q.isEmpty()) {
                    sj.add("-1");
                } else {
                    sj.add(String.valueOf(q.peekLast()));
                }
            } else if(command.equals("empty")) {
                if(q.isEmpty()) {
                    sj.add("1");
                } else {
                    sj.add("0");
                }
            }
        }
        System.out.println(sj);
    }
}
