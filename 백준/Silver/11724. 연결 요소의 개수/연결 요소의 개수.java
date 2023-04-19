import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;
    static boolean[] visited;
    static ArrayList<Integer>[] val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        val = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            val[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            val[start].add(end);
            val[end].add(start);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                cnt++;
            }
            bfs(i);
        }
        System.out.println(cnt);
    }

    static void bfs(int idx) {
        if (visited[idx]) {
            return;
        }
        visited[idx] = true;
        for (int i : val[idx]) {
            bfs(i);
        }
    }
}
