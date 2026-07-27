class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+2];
        for(int i=n-1;i>=0;i--) {
            int take=nums[i]+dp[i+2];
            int skip=dp[i+1];
            dp[i]=Math.max(take,skip);
        }
        return dp[0];
    }
}