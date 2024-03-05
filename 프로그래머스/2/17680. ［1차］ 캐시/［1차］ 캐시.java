import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int len = cities.length;
        int ret = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String city = cities[i].toLowerCase();
            if(map.containsKey(city)) {
                map.put(city, i);
                ret++;
            } else {
                ret += 5;
                map.put(city, i);
                if (map.size() > cacheSize) {
                    String removeKey = "";
                    int time = Integer.MAX_VALUE;
                    for (String mapKey : map.keySet()) {
                        int recent = map.get(mapKey);
                        if (recent < time) {
                            removeKey = mapKey;
                            time = recent;
                        }
                    }
                    map.remove(removeKey);
                }
            }
        }
        return ret;
    }
}