
// 11:24
class Solution {
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int cnt = 3;
        while(n > 0) {
            int rest = n % 3;
            if(rest == 0) {
                sb.append("4");
            } else if(rest == 1 ) {
                sb.append("1");
            } else {
                sb.append("2");
            }
            n  = n - (rest == 0 ? 3 : rest);
            n /= cnt;
        
        }

        return sb.reverse().toString();
    }
}
