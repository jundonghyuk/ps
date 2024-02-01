
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] idxes = new int[n+1];
        for (int i = 1; i <= n; i++) {
            idxes[Integer.parseInt(st.nextToken())] = i;
        }

        int idx = idxes[1];
        int maxSeq = 1;
        int seq = 1;
        for (int i = 2; i <= n; i++) {
            int nextIdx = idxes[i];
            if (idx < nextIdx) {
                seq++;
            } else {
                maxSeq = Math.max(maxSeq, seq);
                seq = 1;
            }
            idx = nextIdx;
        }
        maxSeq = Math.max(maxSeq, seq);
        System.out.println(n - maxSeq);
    }
}
