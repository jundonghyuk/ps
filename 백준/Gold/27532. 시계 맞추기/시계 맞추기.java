
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split(":");
            arr[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 1; i <= 720; i++) {
            Set<Integer> set = new HashSet<>();
            int start = arr[0];
            while(start < 0) {
                start += 720;
            }
            while(start >= 720) {
                start -= 720;
            }
            set.add(start);

            for(int j = 1; j < M; j++) {
                int time = arr[j] - i * j;
                while(time < 0) {
                    time += 720;
                }
                while(time >= 720) {
                    time -= 720;
                }
                set.add(time);
            }
            ret = Math.min(ret, set.size());
        }
        System.out.println(ret);
    }
}
