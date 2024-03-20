import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        HashMap<String, int[]> map = new HashMap<>();
        map.put("E", new int[]{0, 1});
        map.put("W", new int[]{0, -1});
        map.put("N", new int[]{-1, 0});
        map.put("S", new int[]{1, 0});
        int r = 0;
        int c = 0;
        for (int i = 0; i < park.length; i++) {
            boolean find = false;
            for (int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
        int idx = 0;
        for (String s : routes) {
            int originR = r;
            int originC = c;
            String[] split = s.split(" ");
            String dir = split[0];
            int dist = Integer.parseInt(split[1]);
            int[] next = map.get(dir);
            boolean flag = false;
            for (int i = 0; i < dist; i++) {
                int nx = r + next[0];
                int ny = c + next[1];
                
                if (nx < 0 || ny < 0 || nx >= park.length || ny >= park[0].length()) {
                    flag = true;
                    break;
                }
                if (park[nx].charAt(ny) == 'X') {
                    flag = true;
                    break;
                }
                r = nx;
                c = ny;
            }
            if(flag) {
                r = originR;
                c = originC;
            }
        }
        
        return new int[]{r,c};
    }
}