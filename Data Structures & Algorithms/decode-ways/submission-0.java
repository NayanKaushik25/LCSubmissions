class Solution {
    int[] dp;
    private int solve(String s,int i) {
        if(i==s.length()) {
            return 1;
        }
        if(s.charAt(i)=='0') {
            return 0;
        }
        if(dp[i]!=-1) {
            return dp[i];
        }
        int ways=solve(s,i+1);
        if(i+1<s.length()) {
            int num=(s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');
            if(num>=10 && num<=26) 
            {
                ways+=solve(s,i+2);
            }
        }
        dp[i]=ways;
        return ways;
    }
    public int numDecodings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0);
    }
}
