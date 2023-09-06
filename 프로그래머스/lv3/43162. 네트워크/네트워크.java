
import java.util.Arrays;

class Solution {

    static int[] parents;

    public static int solution(int n, int[][] computers) {
        parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        return (int)Arrays.stream(parents)
                .map(i -> find(i))
                .distinct()
                .count();
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        parents[find(b)] = parentA;
    }

    public static int find(int a) {
        if (a == parents[a]) {
            return a;
        }
        return find(parents[a]);
    }
}
