import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        long sum = 0;
        long max = -1;
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();
        for(int i = 0; i < queue1.length; i++) {
            int num = queue1[i];
            d1.addLast(num);
            sum1 += num;
            max = Math.max(max, num);
        }
        
        for(int i = 0; i < queue2.length; i++) {
            int num = queue2[i];
            d2.addLast(num);
            sum2 += num;
            max = Math.max(max, num);
        }
        // 2 3 5 
        // 2 2 2 4
        sum = sum1 + sum2;
        if(sum % 2 == 1 || sum / 2 < max) {
            return -1;
        }
        long diff = sum1 - sum / 2;
        int cnt = 0;
        boolean flag = false;
        while(diff != 0 && cnt <= 600000) {
            if(diff < 0) {
                if(d2.isEmpty()) {
                    flag = true;
                    break;
                }
                int num = d2.pollFirst();
                d1.addLast(num);
                diff += num;
            } else if(diff > 0) {
                if(d1.isEmpty()) {
                    flag = true;
                    break;
                }
                int num = d1.pollFirst();
                d2.addLast(num);
                diff -= num;
            }
            cnt++;
        }
        if(flag) {
            return -1;
        }
        return cnt == 600001 ? -1 : cnt;
    }
}