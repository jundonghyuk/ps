
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

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i+1; j < N; j++) {
                for(int k = j+1; k < N-1; k++) {

                        sum = 0;
                        sum += sum(0, i, arr);
                        sum += sum(i+1, j, arr);
                        sum += sum(j+1, k, arr);
                        sum += sum(k+1, N-1, arr);
                        max = Math.max(sum, max);

                }
            }
        }
        System.out.println(max);
    }
    static int sum(int start, int end, int []arr) {
        int sum = 1;
        for(int i = start; i <= end; i++) {
            sum*=arr[i];
        }
        return sum;
    }
}
