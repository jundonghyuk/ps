
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int ret = 0;
    public static void main(String[] args) throws Exception {
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> missions = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                missions.add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(0, 0, missions, 0, N, M);
        System.out.println(ret);
    }

    public static void dfs(int prevKind, int sum, List<Integer> missions, int depth, int target, int threshold) {
        if (depth >= target) {
            if(threshold <= sum) {
                ret++;
            }
            return;
        }
        for (int i = 0; i < missions.size(); i++) {

            if ((prevKind % 3 == i % 3) && depth != 0) {
                dfs(i,+ (missions.get(i) / 2) + sum, missions, depth + 1, target, threshold);
            } else {
                dfs(i,+ missions.get(i) + sum, missions, depth + 1, target, threshold);
            }
        }
    }
}
