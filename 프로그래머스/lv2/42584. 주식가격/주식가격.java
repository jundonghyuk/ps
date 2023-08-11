
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public static int[] solution(int[] prices) {
        int[] ret = new int[prices.length];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while(!deque.isEmpty() && prices[i] < prices[deque.peekLast()]) {
                ret[deque.peekLast()] = i - deque.peekLast();
                deque.pollLast();
            }
            deque.addLast(i);
        }

        while(!deque.isEmpty()) {
            ret[deque.peekLast()] = prices.length - 1 - deque.pollLast();
        }
        return ret;
    }

    static class Data {
        int idx;
        int value;

        public Data(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
