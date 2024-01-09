
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int N;
    static long[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        arr = new long[N];
        int cnt = 0;
        for (int i = 1; i < firstLine.length; i++) {
            arr[cnt] = convert(Long.parseLong(firstLine[i]));
            cnt++;
        }

        while (cnt < N) {
            String input = br.readLine();
            if(input.trim().isEmpty()) {
                continue;
            }
            String[] line = input.split(" ");
            for (int i = 0; i < line.length; i++) {
                arr[cnt] = convert(Long.parseLong(line[i]));
                cnt++;
            }
        }
        Arrays.sort(arr);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(arr[i]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static long convert(long s) {
        long ret = 0;
        while(s > 0) {
            ret *= 10;
            ret += s % 10;
            s /= 10;
        }
        return ret;
    }
}
