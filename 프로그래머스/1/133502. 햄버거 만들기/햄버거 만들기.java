import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int ret = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int ig : ingredient) {
            dq.addLast(ig);
            // 빵
            if (dq.peekLast() == 1 && dq.size() >= 4) {
                int first = dq.pollLast();
                int second = dq.pollLast();
                if(second != 3) {
                    dq.addLast(second);
                    dq.addLast(first);
                    continue;
                }
                int third = dq.pollLast();
                if (third != 2) {
                    dq.addLast(third);
                    dq.addLast(second);
                    dq.addLast(first);
                    continue;
                }
                int fourth = dq.pollLast();
                if (fourth != 1) {
                    dq.addLast(fourth);
                    dq.addLast(third);
                    dq.addLast(second);
                    dq.addLast(first);
                    continue;
                }
                ret++;
            }
        }
        return ret;
    }
}