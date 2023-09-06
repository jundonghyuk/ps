
import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    static int count = 0;
    public static int solution(int[] numbers, int target) {
        int sum = IntStream.of(numbers).sum();
        int newTarget = (sum + target) /2;
        dfs(0, numbers, 0, newTarget);
        return count;
    }

    public static void dfs(int idx, int[] numbers, int sum, int target) {
        if(sum > target) {
            return;
        }

        if(sum == target) {
            count++;
            return;
        }

        for(int i = idx; i < numbers.length; i++) {
            dfs(i+1, numbers, sum + numbers[i], target);
        }
        
    }
}
