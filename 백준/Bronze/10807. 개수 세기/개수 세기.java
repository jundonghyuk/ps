
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            String num = st.nextToken();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map.getOrDefault(br.readLine(), 0));
    }
}
