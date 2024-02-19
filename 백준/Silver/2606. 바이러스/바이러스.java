
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static List<Integer>[] list;
    static boolean[] visited;
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);
        int ret = 0;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int target : list[poll]) {
                if(visited[target]) continue;
                q.add(target);
                ret++;
                visited[target] = true;
            }
        }
        System.out.println(ret);
    }
}
