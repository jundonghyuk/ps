import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 모든 구간의 거리를 몇 이상으로 만들 때 제거해야하는 돌 개수가 n보다 작을 때 
        // 거리를 더 늘릴 수 있다는 것이니 left = mid + 1;
        // n보다 크다면 그거리는 못만든다는 것이니 right = mid - 1;
        // n과 같다면  거리를 좀 더 늘려볼 수 있으니 left = mid + 1;
        
        
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance + 1;
        
        while(left < right) {
            int mid = (left + right) / 2;
            int length = 0;
            int count = 0;
            for(int i = 0; i <= rocks.length; i++) {
                length += findDist(i, rocks, distance);
                if(length >= mid) {
                    length = 0;
                    continue;
                }
                count++;
            }    
            if(count <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
    
    public int findDist(int i, int[] rocks, int distance) {
         if(i == 0) {
                return rocks[0];
            } else if(i == rocks.length) {
                return distance - rocks[i - 1];
            } else {
                return rocks[i] - rocks[i-1];
            }
    }
}