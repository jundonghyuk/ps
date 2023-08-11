
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < speeds.length; i++) {
            int cnt = 0;
            int speed = speeds[i];
            int rest = 100 - progresses[i];
            int need = rest % speed == 0 ? rest / speed : rest / speed + 1;
            if(rest <= 0) {
                continue;
            }
            boolean flag = true;
            for (int j = i; j < speeds.length; j++) {
                progresses[j] += speeds[j] * need;
                if (flag && progresses[j] >= 100) {
                    cnt++;
                } else {
                    flag = false;
                }
            }
            ret.add(cnt);
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }
}
