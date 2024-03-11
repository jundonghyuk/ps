class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int sc = get(i);
            answer = answer + (sc > limit ? power : sc); 
        }
        return answer;
    }
    
    public int get(int num) {
        int cnt = 0;
        for (int i = 1; i * i <= num; i++) {
            if(num %i ==0) {
                if(num == i*i) {
                    cnt++;
                    continue;
                }
                cnt += 2;
            }
        }
        return cnt;
    }
}