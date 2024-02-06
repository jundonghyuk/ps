
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
    static char[][] map;
    static int n, m, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        HashMap<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Queue<String[]> queue = new LinkedList<>();
                queue.add(new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(0), String.valueOf(map[i][j])});
                while (!queue.isEmpty()) {
                    String[] poll = queue.poll();
                    int x = Integer.parseInt(poll[0]);
                    int y = Integer.parseInt(poll[1]);
                    int idx = Integer.parseInt(poll[2]);
                    freq.put(poll[3], freq.getOrDefault(poll[3], 0) + 1);
                    if (idx == 4) {
                        continue;
                    }
                    for (int dir = 0; dir < 8; dir++) {
                        int nx = (x + dx[dir] + n) % n;
                        int ny = (y + dy[dir] + m) % m;
                        int nIdx = idx + 1;
                        queue.add(new String[]{String.valueOf(nx), String.valueOf(ny), String.valueOf(nIdx), poll[3] + map[nx][ny]});
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (k-- > 0 ) {
            sb.append(freq.getOrDefault(br.readLine(), 0) + "\n");
        }
        System.out.println(sb);
    }
}
