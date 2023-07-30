// start: 7:41 end:
class Solution {

    static int minNum = Integer.MAX_VALUE;

    public static int solution(int storey) {
        dfs(storey, 0);
        return minNum;
    }

    public static void dfs(int num, int depth) {
        if (num == 0) {
            minNum = Math.min(minNum, depth);
            return;
        }
        int rest = 0;
        while (true) {
            rest = num % 10;
            if (rest == 0) {
                num = num / 10;
            } else {
                break;
            }
        }
        dfs(num - rest, depth + rest);
        if (num != 1) {
            dfs(num + (10 - rest), depth + 10 - rest);
        }
    }
}
