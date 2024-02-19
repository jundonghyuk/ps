
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
        visited = new boolean[n + 2];
        list = new List[n + 2];
        for (int i = 1; i <= n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        Queue<int[]> q = new LinkedList<>();
        visited[1] = true;
        q.add(new int[]{1,0});
        int ret = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if(poll[1] >= 2) continue;
            for (int target : list[poll[0]]) {
                if(visited[target]) continue;
                ret++;
                visited[target] = true;
                q.add(new int[]{target, poll[1] + 1});
            }
        }
        System.out.println(ret);
    }
}
