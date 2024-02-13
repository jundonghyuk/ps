
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        left.add(Integer.parseInt(br.readLine()));
        sb.append(left.peek() + "\n");

        if (n == 1) {
            System.out.println(sb);
            return;
        }

        int second = Integer.parseInt(br.readLine());

        if (left.peek() > second) {
            right.add(left.poll());
            left.add(second);
            sb.append(left.peek() + "\n");
        } else {
            right.add(second);
            sb.append(left.peek() + "\n");
        }

        for (int i = 2; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (left.size() == right.size()) {
                if (num <= left.peek()) {
                    left.add(num);
                    sb.append(left.peek() + "\n");
                } else if (num >= right.peek()) {
                    left.add(right.poll());
                    right.add(num);
                    sb.append(left.peek() + "\n");
                } else {
                    left.add(num);
                    sb.append(left.peek() + "\n");
                }
            } else {
                if (num <= left.peek()) {
                    right.add(left.poll());
                    left.add(num);
                    sb.append(left.peek() + "\n");
                } else if (num >= right.peek()) {
                    right.add(num);
                    sb.append(left.peek() + "\n");
                } else {
                    right.add(num);
                    sb.append(left.peek() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
