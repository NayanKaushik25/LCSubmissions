class Solution {
    Integer[] dp;
    private int dfs(int[] nums,int i) {
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
        if(nums.length==1) {
            return nums[0];
        }
        int[] nums1=Arrays.copyOfRange(nums,0,nums.length-1);
        int[] nums2=Arrays.copyOfRange(nums,1,nums.length);
        dp=new Integer[nums1.length];
        int dp1=dfs(nums1,0);
        dp=new Integer[nums2.length];
        int dp2=dfs(nums2,0);
        return Math.max(dp1,dp2);
    }
}
