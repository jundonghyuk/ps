import java.util.Arrays;

class Solution {
    public static long solution(int n, int[] times) {
        int length = times.length;
        Arrays.sort(times);
        long l = 0;
        long answer = 0;
        // maxTime
        long r = (long) n * (long) times[length - 1];
        while (l <= r) {
            int person = 0;
            long mid = (l + r) / 2;
            for (int i = 0; i < length; i++) {
                person += (mid / times[i]);
            }
            if (person >= n) {
                r = mid - 1;
                answer = mid;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }
}
