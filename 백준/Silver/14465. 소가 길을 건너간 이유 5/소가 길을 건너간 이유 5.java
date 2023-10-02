
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] lights = new boolean[n];
        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            lights[num-1] = true;
        }
        int l = 0;
        int r = k-1;
        int min;
        int cnt = 0;
        for(int i = 0; i <= r; i++) {
            if(lights[i]) {
                cnt++;
            }
        }
        min = cnt;
        while(r < n - 1) {
            if(lights[++r]) {
                cnt++;
            }
            if(lights[l++]) {
                cnt--;
            }
            min = Math.min(cnt, min);
        }
        System.out.println(min);
    }
}
