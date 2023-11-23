import java.util.*;

class Solution {
    
    static int min = 0;
    static int[][] alpProblems;
    static int[][] copProblems;
    
    public int solution(int alp, int cop, int[][] problems) {
        int[][] map = new int[302][302];
        for(int i = 0; i <= 301; i++) {
            for(int j = 0; j <= 301; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        int len = problems.length;
        int maxAlp = -1;
        int maxCop = -1;
        for(int i = 0; i < len; i++) {
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }
        if(maxAlp <= alp && maxCop <= cop) {
            return 0;
        }
        if(maxAlp < alp) {
            maxAlp = alp;
        }
        if(maxCop < cop) {
            maxCop = cop;
        }
        map[alp][cop] = 0;
      
        for(int i = alp; i <= maxAlp; i++) {
            for(int j = cop; j <= maxCop; j++) {
                
                map[i+1][j] = Math.min(map[i+1][j], map[i][j] + 1);
                map[i][j+1] = Math.min(map[i][j+1], map[i][j] + 1);
                
                for(int k = 0; k < problems.length; k++) {
                    int alpReq = problems[k][0];
                    int copReq = problems[k][1];
                    int alpAc = problems[k][2];
                    int copAc = problems[k][3];
                    int time = problems[k][4];
                    
        
                    
                    if(alpReq > i || copReq > j) {
                        continue;
                    }
                    
                    int nextAlp = i + alpAc;
                    int nextCop = j + copAc;
                    
                    if(nextAlp <= maxAlp && nextCop <= maxCop) {
                        map[nextAlp][nextCop] = Math.min(map[nextAlp][nextCop], map[i][j] + time);
                    } else if(nextAlp <= maxAlp) {
                        map[nextAlp][maxCop] = Math.min(map[nextAlp][maxCop], map[i][j] + time);
                    } else if(nextCop <= maxCop) {
                        map[maxAlp][nextCop] = Math.min(map[maxAlp][nextCop], map[i][j] + time);
                    } else {
                        map[maxAlp][maxCop] = Math.min(map[maxAlp][maxCop], map[i][j] + time);
                    }
                    
                }
            }
        }
    
        
        return map[maxAlp][maxCop];
    }
}