class Solution {
    public int solution(int n, int[] stations, int w) {
        int cnt = 0;
        int firstRest = stations[0] - w - 1;
        if(firstRest > 0) {
            int plus = firstRest / (2 * w + 1);
            if(firstRest % (2 * w + 1) == 0) {
                cnt += plus;  
            } else {
                cnt += plus + 1;
            }
        }
        for(int i = 0; i < stations.length - 1; i++) {
            int start = stations[i];
            int end = stations[i+1];
            
            int rest = end - w  - 1 - (start + w);
            if(rest <= 0) {
                continue;
            }
            int plus = rest / (2 * w + 1);
            if(rest % (2 * w + 1) == 0) {
                cnt += plus;  
            } else {
                cnt += plus + 1;
            }
        }
        int lastRest = n - (stations[stations.length - 1] + w);
        if(lastRest > 0) {
            int plus = lastRest / (2 * w + 1);
            if(lastRest % (2 * w + 1) == 0) {
                cnt += plus;  
            } else {
                cnt += plus + 1;
            }
        }
        return cnt;
    }
}