class Solution {
    public int solution(String t, String p) {
        int tLen = t.length();
        int pLen = p.length();
        int ret = 0;
        long pNum = Long.parseLong(p);
        for (int i = 0; i <= tLen - pLen; i++) {
            if(Long.parseLong(t.substring(i, i + pLen)) <= pNum) ret++;
        }
        return ret;
    }
}