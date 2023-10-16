import java.util.*;
class Solution {
    static int cnt = 0;
    static boolean flag = false;
    static List<String> ret = new ArrayList<>();
    static Map<String, List<Fly>> flight = new HashMap<>();
    public String[] solution(String[][] tickets) {
        for(int i = 0; i < tickets.length; i++) {
            cnt++;
            String start = tickets[i][0];
            String end = tickets[i][1];
            if(!flight.containsKey(start)) {
                flight.put(start, new ArrayList<>());
            }
            flight.get(start).add(new Fly(end, false));
        }
        
        Set<String> keys = flight.keySet();
        for(String key : keys) {
            Collections.sort(flight.get(key), (f1, f2) -> {
                return f1.end.compareTo(f2.end);
            });
        }
        dfs(1, "ICN");
        String[] answer = new String[ret.size()];
        for(int i = 0; i <ret.size(); i++) {
            answer[i] = ret.get(i);
        }
        return answer;
        
    }
    
    class Fly {
        String end;
        boolean visited;
        
        Fly(String end, boolean visited) {
            this.end = end;
            this.visited = visited;
        }
    }
    
    public void dfs(int depth, String start) {
        if(flag) {
            return;
        }
        
        ret.add(start);
        if(depth == cnt + 1) {
            flag = true;
            return;
        }
        List<Fly> fly = flight.get(start);
        if(fly == null) {
            ret.remove(ret.size() - 1);
            return;
        }
        for(int i = 0; i < fly.size(); i++) {
            if(flag) {
                return;
            }
            Fly now = fly.get(i);
            if(now.visited) {
                continue;
            }
            now.visited = true;
            dfs(depth+1, now.end);
            now.visited = false;
        }
        if(flag) {
            return;
        }
        ret.remove(ret.size() - 1);
    } 
}