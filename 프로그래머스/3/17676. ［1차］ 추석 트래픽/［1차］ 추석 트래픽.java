import java.util.*;

class Solution {
    static long[][] times;
    public int solution(String[] lines) {
        times = new long[lines.length][2];
        for (int i = 0; i < lines.length; i++) {
            long[] ret = parse(lines[i]);
            times[i] = ret;
            // System.out.println(ret[0] + " " + ret[1]);
        }
        // Arrays.sort(times, (o1, o2) -> {
        //    return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
        // });
        int len = times.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            long[] time = times[i];
            int cnt = 0;
            long start = time[1];
            long end = time[1] + 999L;
            for (int j = 0; j < len; j++) {
                long[] other = times[j];
                if(!(other[1] < start || other[0] > end)) {
                    // System.out.println(i + " " + "cnt " + other[0] + " " + other[1]);
                    cnt++;
                }
            }
            max = Math.max(cnt, max);
        }
        return max;
    }
    
    public long[] parse(String line) {
        String[] split = line.split(" ");
        String[] start = split[1].split(":");
        long endTime = Long.parseLong(start[0]) * 60 * 60 * 1000 
            + Long.parseLong(start[1]) * 60 * 1000 
            + (long)(Double.parseDouble(start[2]) * (double)1000);
        
        long spend = (long)(Double.parseDouble(split[2].substring(0, split[2].length() - 1)) * (double)1000) - 1;
        return new long[]{endTime - spend, endTime};
    }
}