import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int t;
    static ArrayList<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list = new ArrayList[v + 1];
            for (int i = 0; i <= v; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                list[v1].add(v2);
                list[v2].add(v1);
            }
            boolean yes = true;

            Queue<Integer> queue = new LinkedList<>();
            visited = new int[v + 1];
            for (int i = 1; i < list.length; i++) {
                if(visited[i] != 0) {
                    continue;
                }
                queue.add(i);
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    int poll = queue.poll();
                    int diff = visited[poll];
                    for (int val : list[poll]) {
                        if (visited[val] == 0) {
                            if (diff == 1) {
                                visited[val] = -1;
                            } else {
                                visited[val] = 1;
                            }
                            queue.add(val);
                        } else {
                            // 같음
                            if (visited[val] * diff == 1) {
                                yes = false;
                                queue.clear();
                                break;
                            }
                        }
                    }
                }
                if (!yes) {
                    break;
                }
            }
            if (yes) {
                bw.write("YES\n" );
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
    }
}
