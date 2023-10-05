import java.util.*;

class Solution {
    static int[] array = {0, 3, 2, 1, 0, -1, -2, -3};
    static int[] reverse = {0, -3, -2, -1, 0, 1, 2, 3};
    public String solution(String[] survey, int[] choices) {
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("C", 0);
        map.put("J", 0);
        map.put("A", 0);
        for(int i = 0; i < survey.length; i++) {
            if(survey[i].startsWith("R")) {
                map.put("R", map.get("R") + array[choices[i]]);
            } else if (survey[i].startsWith("T")) {
                map.put("R", map.get("R") + reverse[choices[i]]);
            } else if (survey[i].startsWith("C")) {
                map.put("C", map.get("C") + array[choices[i]]);
            } else if (survey[i].startsWith("F")) {
                map.put("C", map.get("C") + reverse[choices[i]]);
            } else if (survey[i].startsWith("J")) {
                map.put("J", map.get("J") + array[choices[i]]);
            } else if (survey[i].startsWith("M")) {
                map.put("J", map.get("J") + reverse[choices[i]]);
            } else if (survey[i].startsWith("A")) {
                map.put("A", map.get("A") + array[choices[i]]);
            } else if (survey[i].startsWith("N")) {
                map.put("A", map.get("A") + reverse[choices[i]]);
            }
        }
        String ret = "";
        if(map.get("R") >= 0) {
            ret += "R";
        } else {
            ret += "T";
        }
        
        if(map.get("C") >= 0) {
            ret += "C";
        } else {
            ret += "F";
        }
        
        if(map.get("J") >= 0) {
            ret += "J";
        } else {
            ret += "M";
        }
        
        if(map.get("A") >= 0) {
            ret += "A";
        } else {
            ret += "N";
        }
        return ret;
    }
}