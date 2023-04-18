import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int []arr = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
//        list.sort(Comparator.naturalOrder());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            bw.write(String.valueOf(arr[i]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}