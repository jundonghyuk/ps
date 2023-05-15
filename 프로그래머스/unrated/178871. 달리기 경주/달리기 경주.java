import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map_1 = new HashMap<>();
        Map<Integer, String> map_2 = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            map_1.put(players[i], i);
            map_2.put(i, players[i]);
        }

        for(int i = 0; i < callings.length; i++) {
            Integer val = map_1.get(callings[i]);
            String subs = map_2.get(val - 1);
            
            map_1.put(callings[i], val - 1);
            map_1.put(subs, val);
            map_2.put(val - 1, callings[i] );
            map_2.put(val, subs);
        }
        for(int i = 0; i < map_2.size(); i++) {
            answer[i] = map_2.get(i);
        }

        return answer;
    }
}