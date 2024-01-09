
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<String, Integer> seq = new HashMap<>();
    static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            arr[i] = s;
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (!seq.containsKey(s)) {
                seq.put(s, i);
            }
        }
        Arrays.sort(arr, (s1, s2) -> {
            int s1Num = map.get(s1);
            int s2Num = map.get(s2);
            if (s1Num != s2Num) return s2Num - s1Num;
            int s1Seq = seq.get(s1);
            int s2Seq = seq.get(s2);
            return s1Seq - s2Seq;
        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
