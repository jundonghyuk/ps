
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[] solution(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        ret.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] == arr[i]) {
                continue;
            }
            ret.add(arr[i]);
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }
}
