class Solution {
    int[] dp1, dp2;
    int[] sticker2;
    public int solution(int sticker[]) {
        dp1 = new int[sticker.length];
        dp2 = new int[sticker.length];
        this.sticker2 = sticker.clone();
        
        if(sticker.length == 1)
            return sticker[0];
        
        dp1[0] = sticker[0];
        
        sticker[sticker.length-1] = 0;
        
        for(int i = 1; i < sticker.length; i++){
            if(i == 1){
                dp1[i] = sticker[i];
                dp2[i] = sticker2[i];
            }else if(i == 2){
                dp1[i] = sticker[i] + dp1[0];
                dp2[i] = sticker2[i] + dp2[0];
            }else{
                dp1[i] = sticker[i] + max(dp1[i-2], dp1[i-3]);
                dp2[i] = sticker2[i] + max(dp2[i-2], dp2[i-3]);
            }
        }
        
        int max1 = max(dp1[sticker.length-1], dp1[sticker.length-2]);
        max1 = max(max1, dp2[sticker.length-1]);
        return max(max1, dp2[sticker.length-2]);
    }
    
    int max(int a, int b){
        return a > b ? a : b;
    }
}