class Solution {
    List<List<String>> res=new ArrayList<>();
    List<String> part=new ArrayList<>();
    private boolean isPali(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                return false;
            }
            l=l+1;
            r=r-1;
        }
        return true;
    }
    private void dfs(String s,int i) {
        if (i>=s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j=i;j<s.length();j++) {
            String substr=s.substring(i,j+1);
            if (isPali(substr)) {
                part.add(substr);
                dfs(s,j+1);
                part.remove(part.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        dfs(s,0);
        return res;
    }
}