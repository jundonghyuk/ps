import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] val = new int[N];
        int[] idx = new int[N];

        for (int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(st.nextToken());
            idx[i] = i + 1;
        }

        idx[N - 1] = -1;
        for (int i = N - 2; i >= 0; i--) {
            int j = i + 1;
            while(j >= 0 && j <= N-1 && val[i] >= val[j]) {
                j = idx[j];
            }
            if(j == -1) {
                idx[i] = -1;
            } else {
                idx[i] = j;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            if(idx[i] == -1) {
                bw.write("-1 ");
            } else {
                bw.write(val[idx[i]] + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
