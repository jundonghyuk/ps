
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static List<Integer>[] list;
    static boolean[][] visited;
    static boolean[][] ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new List[n];
        visited = new boolean[n][n];
        ret = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int connected = sc.nextInt();
                if (connected == 1) {
                    list[i].add(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited = new boolean[n][n];
                if (bfs(i, j)) {
                    sb.append("1 ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean bfs(int source, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer next : list[poll]) {
                if (next == target) {
                    return true;
                }
                if (visited[poll][next]) {
                    continue;
                }
                visited[poll][next] = true;
                q.add(next);
            }
        }
        return false;
    }
}
