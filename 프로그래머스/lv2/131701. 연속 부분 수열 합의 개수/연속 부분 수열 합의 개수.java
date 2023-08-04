
import java.util.HashSet;
 
// start 2:30, end: 2:44
class Solution {
    public static int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            int cnt = elements.length;
            int sum = 0;
            for (int j = 0; j < cnt; j++) {
                sum += elements[(i + j) % elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}
