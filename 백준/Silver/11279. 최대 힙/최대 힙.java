
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (num == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll());
                sb.append("\n");
            } else {
                pq.add(num);
            }
        }
        System.out.println(sb);
    }
}
