
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    static int[] array = new int[100001];
    static int[] result = new int[100001];
    public static int[] solution(String s) {
        String temp = s.substring(2, s.length()-2);
        String delimiter = "\\},\\{";
        for (String ch : temp.split(delimiter)) {
            String[] split = ch.split(",");
            for(String k : split) {
                int target = Integer.valueOf(k);
                array[target]++;
            }
        }
        int cnt = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                continue;
            }
            result[array[i]-1] = i;
        }
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < result.length; i++) {
            if(result[i] == 0) {
                break;
            }
            ret.add(result[i]);
        }
        Collections.reverse(ret);
        return ret.stream().mapToInt(i->i).toArray();
    }
}
