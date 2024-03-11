import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s : score) {
            q.add(s);
        }
        int answer = 0;
        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            int poll = q.poll();
            if(cnt == m) {
                answer+=poll * m;
                cnt =0;
            }
        }
        return answer;
    }
}