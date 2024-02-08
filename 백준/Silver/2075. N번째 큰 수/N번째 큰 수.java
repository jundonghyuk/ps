
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n *n ;i++) {
            pq.add(sc.nextInt());
        }
        for (int i = 0; i < n -1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
