
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int HEIGHT, LOCATION, TARGET, U, D;
    static int[] vis = new int[1000001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HEIGHT = Integer.parseInt(st.nextToken());
        LOCATION = Integer.parseInt(st.nextToken());
        TARGET = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(LOCATION);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if(poll == TARGET) {
                System.out.println(vis[poll]);
                return;
            }

            int next = poll + U;
            if(next <= HEIGHT && vis[next] == 0 && next != LOCATION) {
                vis[next] = vis[poll] + 1;
                queue.add(next);
            }

            next = poll - D;
            if(next >= 1 && vis[next] == 0 && next != LOCATION) {
                vis[next] = vis[poll] + 1;
                queue.add(next);
            }
        }
        System.out.println("use the stairs");

    }
}
