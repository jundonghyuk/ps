import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        return Arrays.stream(photo)
            .mapToInt(arr -> 
                      Arrays.stream(arr).mapToInt(ele -> map.getOrDefault(ele, 0)).sum())
            .toArray();
    }
}