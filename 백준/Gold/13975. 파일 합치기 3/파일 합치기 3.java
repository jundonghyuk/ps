
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int t, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> cur = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cur.add(Long.parseLong(st.nextToken()));
            }
            long ret = 0;
            while (!cur.isEmpty()) {
                if (cur.size() == 1) {
                    break;
                }
                Long first = cur.poll();
                Long second = cur.poll();
                cur.add(first + second);
                ret += first + second;
            }
            sb.append(ret + "\n");
        }
        System.out.println(sb);
    }
}
