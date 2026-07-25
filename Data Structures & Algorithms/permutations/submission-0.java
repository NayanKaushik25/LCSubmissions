class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> perm=new ArrayList<>();
    boolean[] used;
    private void dfs(int[] nums) {
        if(nums.length==perm.size()) {
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if (used[i]) continue;
            used[i]=true;
            perm.add(nums[i]);
            dfs(nums);
            perm.remove(perm.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        used=new boolean[nums.length];
        dfs(nums);
        return res;
    }
}
