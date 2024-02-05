
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> numToName = new HashMap<>();
        HashMap<String, Integer> nameToNum = new HashMap<>();
        for (int i = 1; i <= n;i++) {
            String name = br.readLine();
            numToName.put(i, name);
            nameToNum.put(name, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=m;i++) {
            String line = br.readLine();
            try {
                int num = Integer.parseInt(line);
                sb.append(numToName.get(num) + "\n");
            } catch (NumberFormatException e) {
                sb.append(nameToNum.get(line) + "\n");
            }
        }
        System.out.println(sb);
    }
}
