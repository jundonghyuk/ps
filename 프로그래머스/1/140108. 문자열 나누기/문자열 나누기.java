import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        while(s.length() > 0) {
            char ch = s.charAt(0);
            boolean flag = false;
            int prevCnt = 1;
            int nextCnt = 0;
            for (int i = 1; i < s.length(); i++) {
                if(s.charAt(i) == ch) {
                    prevCnt++;
                } else {
                    nextCnt++;
                }
                if(prevCnt == nextCnt) {
                    s = s.substring(i+1, s.length());
                    flag = true;
                    answer++;
                    break;
                }
            }
            if(!flag) {
                answer++;
                break;
            }
        }
        return answer;

    }
}