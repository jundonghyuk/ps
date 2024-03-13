import java.util.*;

class Solution {
    static String[] babblings = {
        "aya", "ye", "woo", "ma"
    };
    
    public int solution(String[] babbling) {
        int answer = 0;

        for (String s : babbling) {
            if(dfs(s, -1)) answer++;
        }
        return answer;
    }
    
    public boolean dfs (String s, int prevIdx) {
        if(s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < babblings.length; i++) {
            if (i == prevIdx) continue;
            if (s.startsWith(babblings[i])) {
                return dfs(s.substring(babblings[i].length(), s.length()), i);
            }
        }
        return false;
    }
}