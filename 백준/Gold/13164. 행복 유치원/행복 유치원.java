
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
        int k = Integer.parseInt(st.nextToken());
        int[] lights = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lights);
        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dist[i] = lights[i+1] - lights[i];
        }
        Arrays.sort(dist);
        //  n-k ~ n-1
        long sum = 0;
        for(int i = 0; i < n -k; i++) {
            sum += dist[i];
        }
        System.out.println(sum);
    }
}
