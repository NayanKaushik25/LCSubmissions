class Solution {
    Integer [] dp;
    private int dfs(int[] nums, int i) {
        if(i>=nums.length) {
            return 0;
        }
        if(dp[i]!=null) {
            return dp[i];
        }
        int take=nums[i]+dfs(nums,i+2);
        int skip=dfs(nums,i+1);
        dp[i]=Math.max(take,skip);
        return dp[i];
    }

    public int rob(int[] nums) {
        dp=new Integer[nums.length];
        return dfs(nums, 0);
    }
}