import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] erase;
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        boolean find = true;
        while (find) {
            find = false;
            erase = new boolean[m][n];
            
            for (int i = 0; i < m - 1 ; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char ch = map[i][j];
                    if (ch != '0' && 
                        ch == map[i][j+1] &&
                        ch == map[i+1][j] &&
                        ch == map[i+1][j+1]) {
                        
                        find = true;
                        if(!erase[i][j]) ret++;
                        if(!erase[i][j+1]) ret++;
                        if(!erase[i+1][j]) ret++;
                        if(!erase[i+1][j+1]) ret++;
                        erase[i][j] = true;
                        erase[i][j+1] = true;
                        erase[i+1][j] = true;
                        erase[i+1][j+1] = true;
                    }
                }
            }
                
            for (int col = 0; col < n; col++) {
                int row = -1;
                for (int empty = m - 1; empty >= 0; empty--) {
                    if (erase[empty][col]) {
                        row = empty;
                        break;
                    }
                }
                if(row == -1) {
                    continue;
                }
                for (int next = row; next >= 0; next--) {
                    if (map[next][col] == '0') {
                        break;
                    }
                    if (!erase[next][col]) {
                        map[row][col] = map[next][col];
                        erase[row][col] = false;
                        erase[next][col] = true;
                        row--;
                    }
                }
            }
                
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(erase[i][j]) {
                        map[i][j] = '0';
                    }
                }
            }
                
        }
        return ret;
    }
}