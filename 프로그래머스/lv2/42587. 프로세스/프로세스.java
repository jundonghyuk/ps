
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static int solution(int[] priorities, int location) {
        Queue<Data> queue = new LinkedList<>();
        int[] rest = new int[10];
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new Data(priorities[i], i));
            int num = priorities[i];
            while (num > 0) {
                num--;
                rest[num]++;
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            if(rest[queue.peek().value] != 0) {
                queue.add(queue.poll());
                continue;
            }
            cnt++;
            Data poll = queue.poll();
            int t = poll.value;
            while (t > 0) {
                t--;
                rest[t]--;
            }
            if(poll.index == location) {
                return cnt;
            }
        }
        return  -1;
    }

    static class Data{
        public int value;
        public int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
