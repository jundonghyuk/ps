
import java.util.PriorityQueue;
import java.util.Scanner;

/*
12:47 ~
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }
        for (int i = 0; i < m; i++) {
            long first = pq.poll();
            long second = pq.poll();
            pq.add(first + second);
            pq.add(first + second);
        }
        long ret= 0;
        while(!pq.isEmpty()) {
            ret += pq.poll();
        }
        System.out.println(ret);
    }
}
