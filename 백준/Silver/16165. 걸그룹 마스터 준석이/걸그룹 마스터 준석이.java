
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> mToT = new HashMap<>();
        HashMap<String, List<String>> tToM = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String team = br.readLine();
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                String member = br.readLine();
                mToT.put(member, team);
                if(tToM.containsKey(team)) {
                    tToM.get(team).add(member);
                } else {
                    List<String> members = new ArrayList<>();
                    members.add(member);
                    tToM.put(team, members);
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            if(Integer.parseInt(br.readLine()) == 0) {
                List<String> strings = tToM.get(line);
                Collections.sort(strings);
                for (String string : strings) {
                    sb.append(string + "\n");
                }
            } else {
                sb.append(mToT.get(line) + "\n");
            }
        }
        System.out.println(sb);
    }

}
