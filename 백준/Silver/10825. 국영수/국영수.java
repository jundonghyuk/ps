
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static String[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N][4];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            arr[i] = split;
        }
        Arrays.sort(arr, (String[] s1, String[] s2) -> {
            int s1Korean = Integer.parseInt(s1[1]);
            int s2Korean = Integer.parseInt(s2[1]);
            if (s1Korean != s2Korean) return s2Korean - s1Korean;

            int s1English = Integer.parseInt(s1[2]);
            int s2English = Integer.parseInt(s2[2]);
            if (s1English != s2English) return s1English - s2English;

            int s1Math = Integer.parseInt(s1[3]);
            int s2Math = Integer.parseInt(s2[3]);
            if (s1Math != s2Math) return s2Math - s1Math;
            return s1[0].compareTo(s2[0]);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
