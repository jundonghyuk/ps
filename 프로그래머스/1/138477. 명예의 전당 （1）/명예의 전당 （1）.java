import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] answer = new int[score.length];
        int idx = 0;
        for (int sc : score) {
            q.add(sc);
            if (q.size() > k) {
                q.poll();
            }
            answer[idx++] = q.peek();
        }
    
        return answer;
    }
}