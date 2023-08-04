
import java.util.ArrayDeque;
import java.util.Deque;

// 2:09
class Solution {
    public static int solution(int[] order) {
        int start = 1;
        int sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int item : order) {
            if(start == item) {
                start++;
                sum++;
            } else if(start < item) {
                for(int i = start; i <= item-1; i++ ) {
                    deque.addFirst(i);
                }
                sum++;
                start = item+1;
            } else {
                if(deque.pollFirst() == item) {
                    sum++;
                } else {
                    break;
                }
            }
        }
        return sum;
    }
}
