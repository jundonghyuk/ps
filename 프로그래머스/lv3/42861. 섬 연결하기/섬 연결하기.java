
import java.util.Arrays;
import java.util.PriorityQueue;

// 4:46
class Solution {
    public static int solution(int n, int[][] costs) {
        if (n==1) {
            return 0;
        }
        boolean[] visited = new boolean[n];
        int cost = 0;
        Arrays.sort(costs, (o1, o2) -> {
            if (o1[2] > o2[2]) {
                return 1;
            }
            return -1;
        });
        int[][] value = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                value[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < costs.length; i++) {
            int[] val = costs[i];
            value[val[0]][val[1]] = val[2];
            value[val[1]][val[0]] = val[2];
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
            if (o1[2] > o2[2]) {
                return 1;
            }
            return -1;
        }));

        int[] first = costs[0];
        queue.add(first);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int start = poll[0];
            int end = poll[1];
            int idx = -1;

            if(visited[start] && visited[end]) {
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        if (value[start][i] != Integer.MAX_VALUE) {
                            queue.add(new int[]{start, i, value[start][i]});
                            idx = i;
                        }
                        if (value[end][i] != Integer.MAX_VALUE) {
                            queue.add(new int[]{end, i, value[end][i]});
                            idx = i;
                        }
                    }
                }
                continue;
            }
            visited[start] = true;
            visited[end] = true;
            cost += poll[2];
            int source = -1;
            int tempCount = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    if (value[start][i] != Integer.MAX_VALUE) {
                        queue.add(new int[]{start, i, value[start][i]});
                        idx = i;
                    }
                    if (value[end][i] != Integer.MAX_VALUE) {
                        queue.add(new int[]{end, i, value[end][i]});
                        idx = i;
                    }
                }
            }
            if (idx == -1) {
                break;
            }
        }
        return cost;
    }
}
