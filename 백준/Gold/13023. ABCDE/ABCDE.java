import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int boundary = 5;
    static boolean ret = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start].add(end);
            map[end].add(start);
        }

        for(int i = 0; i < N; i++)  {
            dfs(1, i);
        }
        if(ret) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int cnt, int idx) {
//        System.out.println(cnt + " " + idx);
        if (ret || visited[idx]) {
            return;
        }
        if (cnt >= boundary) {
            ret = true;
            return;
        }
        visited[idx] = true;

        for(int i :  map[idx]) {
            dfs(cnt + 1, i);
        }
        visited[idx] = false;
    }
}
