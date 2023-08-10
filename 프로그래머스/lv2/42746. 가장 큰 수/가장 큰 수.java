
import java.util.*;

// 12:04 ~
class Solution {

    public static String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length ; i++) {
            list.add(Integer.toString(numbers[i]));
        }
        Collections.sort(list, (s1, s2) -> (s2 +s1).compareTo(s1 +s2));
        int check = 0;
        for(String s: list) {
            if(s.equals("0")) {
                check++;
            }
            sb.append(s);
        }
        if(numbers.length == check) {
            return "0";
        }
        return sb.toString();
    }
}
