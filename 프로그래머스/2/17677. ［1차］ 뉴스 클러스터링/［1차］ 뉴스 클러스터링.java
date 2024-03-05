import java.util.*;
/*
    유사도 = 교집합크기 / 합집합크기
*/
class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> left = new HashMap<>();
        HashMap<String, Integer> right = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            if (!(ch1 >= 'a' && ch1 <= 'z') && !(ch1 >= 'A' && ch1 <= 'Z')) continue;
            if (!(ch2 >= 'a' && ch2 <= 'z') && !(ch2 >= 'A' && ch2 <= 'Z')) continue;
            String str = String.valueOf(ch1).toLowerCase() + String.valueOf(ch2).toLowerCase();
            set.add(str);
            left.put(str, left.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);
            if (!(ch1 >= 'a' && ch1 <= 'z') && !(ch1 >= 'A' && ch1 <= 'Z')) continue;
            if (!(ch2 >= 'a' && ch2 <= 'z') && !(ch2 >= 'A' && ch2 <= 'Z')) continue;
            String str = String.valueOf(ch1).toLowerCase() + String.valueOf(ch2).toLowerCase();
            set.add(str);
            right.put(str, right.getOrDefault(str, 0) + 1);
        }
        
        int intersection = 0;
        int union = 0;
        for (String key : set) {
            int leftSize = left.getOrDefault(key, 0);
            int rightSize = right.getOrDefault(key, 0);
            
            union += Math.max(leftSize, rightSize);
            intersection += Math.min(leftSize, rightSize);
        }
        // System.out.println(union + " " + intersection);
        if(union == 0) {
            return 65536;
        }
        return (int)((double)intersection / (double)union * (double)65536);
    }
}