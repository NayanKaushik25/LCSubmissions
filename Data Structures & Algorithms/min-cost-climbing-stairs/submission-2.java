class Solution {
    Integer [] dp;
    private int dfs(int[] cost,int i) {
        if(i>=cost.length) {
            return 0;
        }
        if(dp[i]!=null) {
            return dp[i];
        }
        int take1=cost[i]+dfs(cost,i+1);
        int take2=cost[i]+dfs(cost,i+2);
        dp[i]=Math.min(take1,take2);
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        dp=new Integer[cost.length];
        return Math.min(dfs(cost,0),dfs(cost,1));
    }
}
