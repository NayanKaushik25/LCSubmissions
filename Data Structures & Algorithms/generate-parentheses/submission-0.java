class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,0,0,"");
        return ans;
    }
    private void dfs(int n,int openct,int closect,String curr) {
        if(curr.length()==2*n) {
            ans.add(curr);
            return;
        }
        if(openct<n) 
        {
            dfs(n,openct+1,closect,curr+"(");
        }
        if(closect<openct) {
            dfs(n,openct,closect+1,curr+")");
        }
    }
}
