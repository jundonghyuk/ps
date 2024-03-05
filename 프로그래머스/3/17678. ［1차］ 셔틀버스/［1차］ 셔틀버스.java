import java.util.*;

/*
    도착 시간에 맞춰 온 승객도 탑승 가능
    콘은 같이 도착한 사람 중 제일 늦게 선다
    처음 버스 부터 마지막 버스까지 모두 탈 수 있게 마지막 타임을 구한다.
    버스가 모두 수용가능하면 -> 버스 출발 시각에 도착하면 된다.
    버스가 모두 수용가능하지않으면 -> m명 이상이 최초로 되는 시각 -1이 도착시각이어야한다.
    나머지 못탄인원은 다시 큐에 넣어줘야한다.
    
*/
class Solution {
    static PriorityQueue<Integer> waiting = new PriorityQueue<>();
    
    public String solution(int n, int t, int m, String[] timetable) {
        int len = timetable.length;
        int max = 0;
        // init
        for (int i = 0; i < len; i++) {
            String[] split = timetable[i].split(":");
            waiting.add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        }
        
        for (int i = 0; i < n; i++) {
            int arrive = 540 + i * t;
            List<Integer> people = new ArrayList<>();
            while (!waiting.isEmpty() && waiting.peek() <= arrive) {
                people.add(waiting.poll());
            }
            
            if (people.size() < m) {
                max = Math.max(max, arrive);
            } else {
                max = Math.max(max, people.get(m - 1) - 1);
                for (int j = m; j < people.size(); j++) {
                    waiting.add(people.get(j));
                }
            }
        }
        // System.out.println(max);
        int hours = max / 60;
        int minutes = max % 60;
        return (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes);
    }
}