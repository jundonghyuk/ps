import java.util.*;
/*
    1. 한 숫자가 억억단에 몇번 나타나는지 ? root(5000000) = 2200
    2. s ~ e 비교 5000000
*/

class Solution {
    public int[] solution(int e, int[] starts) {
        int[][] rets = new int[e][2];
        int[] sols = new int[starts.length];
        for (int i = 1; i <= e; i++) {
            for (int j = 1; i * j <= e; j++) {
                rets[i * j - 1][0]++;
            }
        }
        
        for (int i = 1; i <= e; i++) {
            rets[i - 1][1] = i;
        }
        Arrays.sort(rets, (o1, o2) -> {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
        });
    
        for (int i = 0; i < starts.length; i++) {
            for (int[] ret : rets) {
                if(ret[1] >= starts[i]) {
                    sols[i] = ret[1];
                    break;
                }
            }
        }
        
        return sols;
    }
    
    public int count(int num) {
        int cnt = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    cnt++;
                } else {
                    cnt = cnt + 2;
                }
            }
        }
        return cnt;
    }
}