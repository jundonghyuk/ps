import java.util.*;

public class Main {

    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static Deque<Integer> waiting = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt() - 1;
        map = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            int start = sc.nextInt() -1;
            int end = sc.nextInt() -1;
            map[start].add(end);
            map[end].add(start);
        }

        for(int i = 0; i < N; i++) {
            map[i].sort(Comparator.naturalOrder());
        }
        dfs(V);
        System.out.println();
        waiting.addLast(V);
        Arrays.fill(visited, false);
        visited[V] = true;
        bfs();
    }

    static void dfs(int idx) {
        if(visited[idx]) {
            return;
        }
        visited[idx] = true;
        System.out.print((idx+1) + " ");

        for(int i : map[idx]) {
            dfs(i);
        }
    }

    static void bfs() {
        while(!waiting.isEmpty()) {
            int first = waiting.pollFirst();
            System.out.print((first+1) + " ");
            for(int i : map[first]) {
                if(!visited[i]) {
                    waiting.addLast(i);
                    visited[i] = true;
                }
            }
        }
    }
}
