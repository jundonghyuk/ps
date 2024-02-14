
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Long>[] list = new ArrayList[n + 1];
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(Long.parseLong(st.nextToken()));
        }

        int time = 1;
        long ret = 0;
        for (time = n; time >= 1; time--) {
            pq.addAll(list[time]);
            if (pq.isEmpty()) continue;
            ret += pq.poll();
        }
        System.out.println(ret);
    }
}
