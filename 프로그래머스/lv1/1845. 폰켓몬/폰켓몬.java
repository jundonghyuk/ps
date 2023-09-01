
import java.util.HashSet;
import java.util.Set;

// 15:05
class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return nums.length / 2 < set.size() ? nums.length / 2 : set.size();
    }
}
