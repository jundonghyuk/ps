class Solution {
    public int solution(int a, int b, int n) {
        int ret = 0;
        while(n >= a) {
            int q = (n / a) * b;
            ret += q;
            n %= a;
            n += q;
        }
        return ret;
    }
}