import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                if(map.containsKey(s.charAt(i))) {
                     map.put(s.charAt(i), (int)Math.min(map.get(s.charAt(i)), i + 1));
                } else {
                    map.put(s.charAt(i), i + 1);
                }
            }
        }
        int[]ret = new int[targets.length];
        int idx = 0;
        for (String s : targets) {
            int cnt = 0;
            boolean flag = true;
            for (char ch : s.toCharArray()) {
                if(!map.containsKey(ch)) {
                    ret[idx] = -1;
                    idx++;
                    flag = false;
                    break;
                } else {
                    cnt += map.get(ch);
                }
            }
            if(flag) {
                ret[idx++] = cnt;
            }
        }
        return ret;
    }
}