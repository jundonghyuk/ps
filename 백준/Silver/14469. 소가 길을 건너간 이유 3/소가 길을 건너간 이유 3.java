
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int[][] cows = new int[n][2];

        for (int i = 0; i < cows.length; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, (o1, o2) -> {
                    if(o1[0] < o2[0]) {
                        return -1;
                    } else if (o1[0] > o2[0]) {
                        return 1;
                    } else {
                        return o1[1]-o2[1];
                    }
        });
        int start = cows[0][0] + cows[0][1];
        for(int i = 1; i < n; i++) {
            int startTime = cows[i][0];
            int duration = cows[i][1];
            if (startTime > start) {
                start = startTime;
            }
            start += duration;
        }
        System.out.println(start);
    }
}
