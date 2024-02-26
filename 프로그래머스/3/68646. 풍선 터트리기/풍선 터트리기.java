import java.util.*;

class Solution {
    public int solution(int[] a) {
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(right, Integer.MAX_VALUE);
        left[0] = a[0];
        right[len - 1] = a[len - 1];
        for (int i = 1; i < len; i++) {
            left[i] = Math.min(left[i-1], a[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], a[i]);
        }
        
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if(i==0 || i == len-1) {
                ret++;
                continue;
            }
            if(a[i] < left[i-1] || a[i] < right[i+1]) {
                ret++;
            }
        }
        return ret;
    }
}