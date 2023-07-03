class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int ansLeft = Integer.MAX_VALUE;
        int ansRight = 0;
        int ansLength = Integer.MAX_VALUE;
        long sum = 0;


        for (right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if (sum == k) {
                if (ansLength > right - left) {
                    ansLength = right - left;
                    ansLeft = left;
                    ansRight = right;
                } else if (ansLength == right - left) {
                    if (ansLeft > left) {
                        ansLeft = left;
                        ansRight = right;
                    }
                }
            }
        }
        return new int[] {ansLeft, ansRight};
    }
}
