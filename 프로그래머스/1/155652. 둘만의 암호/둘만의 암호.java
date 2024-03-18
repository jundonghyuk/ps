import java.util.*;

class Solution {
    static char[] trans = new char[26];
    static HashSet<Character> set = new HashSet<>();
    public String solution(String s, String skip, int index) {
        for (char ch : skip.toCharArray()) {
            set.add(ch);
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            int gap = 0;
            int cnt = 0;
            while(cnt != index) {
                gap++;
                if (!set.contains((char)('a' +((i+ gap) % 26)))) {
                    cnt++;
                }
            }
            trans[i] = (char)('a' +(i+ gap) % 26);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(trans[ch - 'a']);
        }
        return sb.toString();
    }
}