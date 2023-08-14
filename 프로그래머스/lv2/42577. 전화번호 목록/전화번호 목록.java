import java.util.Arrays;
import java.util.HashSet;

//  6:23 ~
class Solution {
    public static boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        Arrays.sort(phone_book, (s1, s2) -> s1.length() - s2.length());

        for (String s : phone_book) {
            for(int i = 0; i < s.length(); i++) {
                if(set.contains(s.substring(0, i))) {
                    return false;
                }
            }
            set.add(s);
        }
        return true;
    }
}
