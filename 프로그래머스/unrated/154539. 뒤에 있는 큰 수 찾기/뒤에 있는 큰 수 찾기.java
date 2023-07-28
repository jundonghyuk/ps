import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
    public static int[] solution(int[] numbers) {
        Deque<Integer> ret = new ArrayDeque<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(numbers[numbers.length - 1]);
        ret.addFirst(-1);
        for (int i = numbers.length - 2; i >= 0; i--) {
            int number = numbers[i];
            while (!deque.isEmpty()) {
                Integer top = deque.peekFirst();
                if(top > number) {
                    ret.addFirst(top);
                    break;
                } else {
                    deque.removeFirst();
                }
            }
            deque.addFirst(number);
            if(deque.size() ==1) {
                ret.addFirst(-1);
            }
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }
}
