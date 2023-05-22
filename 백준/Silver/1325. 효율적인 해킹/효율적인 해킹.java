import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] result;
    static int cnt = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int source = Integer.parseInt(st.nextToken());
            list[source].add(target);
        }

        for (int i = 1; i <= N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            visited = new boolean[N+1];
            queue.add(i);
            int temp = 0;
            visited[i] = true;
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                temp++;
                for (int j : list[poll]) {
                    if(visited[j]) {
                        continue;
                    }
                    visited[j] = true;
                    queue.add(j);
                }
            }
            result[i] = temp;
        }

        for(int i = 0; i < result.length; i++) {
            cnt = Math.max(cnt, result[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i =0; i < result.length; i++) {
            if(result[i] == cnt) {
                bw.write(i + " ");
            }
        }
        bw.flush();
    }
}
