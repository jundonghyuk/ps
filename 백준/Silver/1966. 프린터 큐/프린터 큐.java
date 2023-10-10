
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Printer> pq = new LinkedList<>();
            int[] nums = new int[10];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                for(int j = 1; j < num; j++) {
                    nums[j]++;
                }
                pq.add(new Printer(i, num));
            }
            int cnt = 0;
            while(true) {
                Printer poll = pq.poll();
                if(nums[poll.priority] == 0){
                    for(int i = 1; i < poll.priority; i++) {
                        nums[i]--;
                    }
                    cnt++;
                    if(poll.idx == M) {
                        System.out.println(cnt);
                        break;
                    }
                } else {
                    pq.add(poll);
                }
            }
        }
    }

    static class Printer {
        int idx;
        int priority;

        public Printer(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}
