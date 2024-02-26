import java.util.*;

class Solution {
    static int[][] arr;
    public int solution(int[] a) {
        arr = new int[a.length][2];
        int len = a.length;
        for (int i = 0; i < len; i++) {
            arr[i][0] = i;
            int num = a[i];
            arr[num][1]++;
        }
        Arrays.sort(arr,(o1,o2)-> {
            return o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0];
        });
        int ret = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt = 0;
            int[] nums = arr[i];
            int num = nums[0];
            
            boolean target = false;
            boolean other = false;
            if (nums[1] * 2 <= ret) {
                continue;
            }
            for (int j = 0; j < len; j++) {
                if(a[j] == num) {
                    target = true;
                }
                if(a[j] != num) {
                    other = true;
                }
                if(target && other) {
                    cnt += 2;
                    target = false;
                    other = false;
                }
            }
            if(cnt == nums[1] * 2 && cnt > ret) {
                return cnt;
            }
            if(cnt > 0) {
                ret = Math.max(ret, cnt);
            }
        }
        return ret;
    }
}