
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int LOCATION, TARGET;
    static int[] loc = new int[200001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LOCATION = Integer.parseInt(st.nextToken());
        TARGET = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(loc, -1);
        loc[LOCATION] = 0;
        q.add(LOCATION);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == TARGET) {
                System.out.println(loc[cur]);
                return;
            }
            int teleport = cur * 2;
            while (teleport < 200001) {
                if (loc[teleport] == -1) {
                    q.add(teleport);
                    loc[teleport] = loc[cur];
                    teleport *= 2;
                } else {
                    break;
                }
            }
            if (cur - 1 >= 0 && loc[cur - 1] == -1) {
                q.add(cur - 1);
                loc[cur - 1] = loc[cur] + 1;
            }
            
            if (cur + 1 < 200001 && loc[cur + 1] == -1) {
                q.add(cur + 1);
                loc[cur + 1] = loc[cur] + 1;
            }
        }
    }
}
