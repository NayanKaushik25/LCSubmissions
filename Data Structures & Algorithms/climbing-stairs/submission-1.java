class Solution {
    int[] cache;
    public int dfs(int n,int i) {
        if(i>=n) return i==n?1:0;
        if(cache[i]!=-1) return cache[i];
        cache[i]=dfs(n,i+1)+dfs(n,i+2);
        return cache[i];
    }
    public int climbStairs(int n) {
        cache=new int[n];
        for(int i=0;i<n;i++) {
            cache[i]=-1;
        }
        return dfs(n,0);
    }
}
