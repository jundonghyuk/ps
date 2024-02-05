
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> counts = new HashMap<>();
        HashMap<String, Integer> curCounts = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            String line = br.readLine();
            list.add(line);
            counts.put(line, counts.getOrDefault(line, 0) + 1);
            curCounts.putIfAbsent(line, 0);
        }
        StringBuilder sb = new StringBuilder();
        int size = 0;
        for (int i = 0; i < l; i++) {
            String s = list.get(i);
            if (counts.get(s).equals(1)) {
                sb.append(s + "\n");
                size++;
            } else {
                if(counts.get(s).equals(curCounts.get(s) + 1)) {
                    sb.append(s + "\n");
                    size++;
                } else {
                    curCounts.put(s, curCounts.get(s) + 1);
                }
            }
            if(size == n) {
                break;
            }
        }
        System.out.println(sb);
    }
}
