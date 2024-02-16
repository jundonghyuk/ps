import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] me = scores[0];
        
        Arrays.sort(scores, (o1, o2) -> {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
        });
        
        int max = -1;
        int ret = 1;
        for (int[] score : scores) {
            if (score[1] >= max) {
                max = score[1];
                if(me[0] + me[1] < score[0] + score[1]) {
                    ret++;
                }
            } else {
                if(score.equals(me)) {
                 
                    return -1;
                }
            }
        }
        return ret;
    }
}