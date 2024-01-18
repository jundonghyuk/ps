import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Number> dq = new ArrayDeque<>();
        dq.add(new Number(0, arr[0]));
        System.out.print(arr[0]);
        for (int i = 1; i < N; i++) {
            while(dq.getLast().getValue() > arr[i]) {
                dq.pollLast();
                if(dq.isEmpty()) {
                    break;
                }
            }
            dq.addLast(new Number(i, arr[i]));

            if(dq.getFirst().getIdx() <= i - L ) {
                dq.pollFirst();
            }
            bw.write(" " + dq.getFirst().getValue());
        }
        bw.flush();
        bw.close();
    }

    static class Number {
        int idx;
        int value;

        public Number(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int getIdx() {
            return idx;
        }

        public int getValue() {
            return value;
        }
    }
}
