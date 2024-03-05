
import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] rets = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int rev1 = (int)Math.pow(2, n) - 1 - arr1[i];
            int rev2 = (int)Math.pow(2, n) - 1 - arr2[i];
            int ret = rev1 & rev2;
            for (int j = 0; j < n; j++) {
                int mod = ret % 2;
                if(mod == 1) {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
                ret /= 2;
            }
            rets[i] = sb.reverse().toString();
        }
        return rets;
    }
}