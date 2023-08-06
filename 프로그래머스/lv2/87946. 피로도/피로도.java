
import java.util.Arrays;

// 5:42 ~ 6:05
class Solution {
    static boolean[] visited;
    static int realSum = 0;

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        Arrays.sort(dungeons, (o1, o2) -> {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
        });

        dfs(0, k, dungeons, 0);
        return realSum;
    }

    public static void dfs(int start, int k, int[][] dungeons, int sum) {
        if (start >= dungeons.length) {
            realSum = Math.max(sum, realSum);
            return;
        }

        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i]) {
                continue;
            }
            int minimum = dungeons[i][0];
            int need = dungeons[i][1];
            if (minimum > k || need > k) {
                visited[i] = true;
                dfs(start + 1, k, dungeons, sum);
                visited[i] = false;
            } else {
                visited[i] = true;
                dfs(start + 1, k, dungeons, sum);
                dfs(start + 1, k - need, dungeons, sum + 1);
                visited[i] = false;
            }
        }
    }
}
