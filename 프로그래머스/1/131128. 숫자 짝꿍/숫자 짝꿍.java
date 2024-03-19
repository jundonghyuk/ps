import java.util.*;
class Solution {
    static int[][] arr = new int[10][2];
    public String solution(String X, String Y) {
        for (char ch : X.toCharArray()) {
            arr[ch -'0'][0]++;
        }
        for (char ch : Y.toCharArray()) {
            arr[ch -'0'][1]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i>=1;i--) {
            int cnt = (int)Math.min(arr[i][0], arr[i][1]);
            for (int j = 0; j < cnt; j++) {
                sb.append(i);
            }
        }
        if (sb.toString().length() == 0) {
            if((int)Math.min(arr[0][0], arr[0][1]) ==0) {
                return "-1";
            } else {
                return "0";
            }
        }
        int cnt = (int)Math.min(arr[0][0], arr[0][1]);
            for (int j = 0; j < cnt; j++) {
                sb.append("0");
            }
        return sb.toString();
    }
}