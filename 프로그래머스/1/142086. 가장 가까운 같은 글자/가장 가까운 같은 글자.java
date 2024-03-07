import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] arr = new int[26];
        int[] answer = new int[s.length()];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            answer[i] = arr[s.charAt(i) - 'a'] == -1 ? -1 : i - arr[s.charAt(i) - 'a'];
            arr[s.charAt(i) - 'a'] = i;
        }
        return answer;
    }
}