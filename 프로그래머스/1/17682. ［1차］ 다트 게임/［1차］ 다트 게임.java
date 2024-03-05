import java.util.*;

/*
        스타상: 방금 점수와 이전 점수 두배, 첫 시도시 첫 시도만 두배
        아차상: 점수 마이너스
        
*/
class Solution {
    static int[] scores;
    public int solution(String dartResult) {
        int answer = 0;
        int len = dartResult.length();
        scores = new int[3];
        int idx = 0;
        for(int t = 0; t < 3; t++) {
            int score = 0;
            int multi = 0;
            int special = 0;
            
            for (int i = idx; i < len; i++) {
                char ch = dartResult.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    if (multi != 0) break;
                    score = 10 * score + (ch - '0');
                } else if (ch == 'S') {
                    multi = 1;
                } else if (ch == 'D') {
                    multi = 2;
                } else if (ch == 'T') {
                    multi = 3;
                } else if (ch == '#') {
                    special = 1;
                    idx++;
                    break;
                } else if (ch == '*') {
                    special = 2;
                    idx++;
                    break;
                }
                idx++;
            }
            
            if (special == 0) {
                scores[t] = (int)Math.pow(score, multi);
            } else if (special == 1){
                scores[t] = (-1) * (int)Math.pow(score, multi);
            } else {
                if (t == 0) {
                    scores[t] = (int)Math.pow(score, multi);
                    scores[t] *= 2;
                } else {
                    scores[t] = (int)Math.pow(score, multi);
                    scores[t-1] *= 2;
                    scores[t] *= 2;
                }
            }
            
        }
        for (int i = 0; i < 3; i++) {
            answer += scores[i];
        }
        return answer;
    }
}