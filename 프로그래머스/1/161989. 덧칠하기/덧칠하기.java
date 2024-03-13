import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int s : section) {
            q.add(s);
        }
        int cnt = 0;
        int ret = 0;
        int num = 0;
        while(!q.isEmpty()) {
            int poll = q.poll();
            if(num == 0) {
                num = poll;
            }
            while(!q.isEmpty() && q.peek() <= num + m - 1) {
                q.poll();
            }
            num = 0;
            ret++;
        }
        return ret;
    }
}