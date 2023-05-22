import java.util.*;

public class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] list;
    static List<Integer> result = new ArrayList<>();
    static boolean[] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int source = sc.nextInt();
            int target = sc.nextInt();
            list[source].add(target);
        }
        queue.add(new int[]{X, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int source = poll[0];
            if (visited[source] == true) {
                continue;
            }
            visited[source] = true;
            int depth = poll[1];
            if(depth == K) {
                result.add(source);
                continue;
            }
            for (int i = 0; i < list[source].size(); i++) {
                queue.add(new int[]{list[source].get(i), depth + 1});
            }
        }

        Collections.sort(result);
        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            for (int val : result) {
                System.out.println(val);
            }
        }
    }
}
