import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int mid = s / n;
        int rest = s % n;
        if(mid == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        for(int i = 0; i < n - rest; i++) {
            answer[i] = mid;
        }
        for(int i = n - rest; i < n; i++) {
            answer[i] = mid + 1;
        }
        return answer;
    }
}