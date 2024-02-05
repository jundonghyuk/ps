
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            if (split[1].equals("enter")) {
                set.add(split[0]);
            } else {
                set.remove(split[0]);
            }
        }
        List<String> list = set.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
