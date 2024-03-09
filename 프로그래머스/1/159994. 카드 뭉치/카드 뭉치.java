class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < goal.length; i++) {
            if (l < cards1.length && cards1[l].equals(goal[i])) {
                l++;
                continue;
            }
            if (r < cards2.length && cards2[r].equals(goal[i])) {
                r++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }
}