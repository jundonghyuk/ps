
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                map.put(line[1], map.getOrDefault(line[1], 0) + 1);
            }
            long sum = 1;
            for (Integer i : map.values()) {
                sum *= (i + 1);
            }
            System.out.println(sum - 1);
        }
    }
}
