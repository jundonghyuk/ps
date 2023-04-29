import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static List<int[]> safeAreas;
    static Deque<int[]> candidates;
    static int safeArea = 0;
    static int ret = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        int total = N * M;
        int wall = 0;
        queue = new LinkedList<>();
        safeAreas = new ArrayList<>();
        candidates = new LinkedList<>();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    wall++;
                } else {
                    safeAreas.add(new int[]{i, j});
                    safeArea++;
                }
            }
        }

        getCombination();
        System.out.println(ret);
    }

    static void bfs() {
        Queue<int[]> tempQueue = new LinkedList<>(queue);
        for(int i = 0 ; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        if(candidates.size() != 3) {
            throw new IllegalStateException();
        }

        int[] first = candidates.poll();
        int[] second = candidates.poll();
        int[] third = candidates.poll();

        map[first[0]][first[1]] = 1;
        map[second[0]][second[1]] = 1;
        map[third[0]][third[1]] = 1;

        int sum = 0;
        while (!tempQueue.isEmpty()) {
            int[] location = tempQueue.poll();
            visited[location[0]][location[1]] = true;

            if(map[location[0]][location[1]] == 0) {
                sum++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = location[0] + dx[i];
                int ny = location[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (map[nx][ny] != 0 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                tempQueue.offer(new int[] {nx, ny});
            }
        }
        ret = Math.max(ret, safeArea - sum - 3);
//        if(first[0] == 0  && first[1]== 1 && second[0] == 1 && second[1] == 0 && third[0] == 3 && third[1] == 5) {
//        if(ret == -1) {
//            for(int i = 0; i < N; i++ ) {
//                for(int j = 0; j < M;j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println(sum);
//        }

        map[first[0]][first[1]] = 0;
        map[second[0]][second[1]] = 0;
        map[third[0]][third[1]] = 0;
    }

    static void getCombination() {

        for (int i = 0; i < safeAreas.size(); i++) {
            for (int j = i + 1; j < safeAreas.size(); j++) {
                for (int k = j + 1; k < safeAreas.size(); k++) {
                    candidates.clear();
                    candidates.offer(safeAreas.get(i));
                    candidates.offer(safeAreas.get(j));
                    candidates.offer(safeAreas.get(k));
//                    System.out.println(i +" " + j + " " + k);
                    bfs();

                }
            }
        }

    }
}
