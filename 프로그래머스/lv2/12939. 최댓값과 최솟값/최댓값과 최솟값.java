
import java.util.Arrays;

class Solution {
    public static String solution(String s) {
        String[] split = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String s1 : split) {
            max = Math.max(max, Integer.parseInt(s1));
            min = Math.min(min, Integer.parseInt(s1));
        }
        return min + " "  + max;
    }
}
