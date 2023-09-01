
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 15:05
class Solution {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();
        for (String s : participant) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
                continue;
            }
            map.put(s, 1);
        }
        for (String s : completion) {
            Integer cnt = map.get(s);
            if(cnt > 1) {
                map.put(s, map.get(s) - 1);
                continue;
            }
            map.remove(s);
        }
        return (String) (map.keySet().toArray()[0]);
    }
}
