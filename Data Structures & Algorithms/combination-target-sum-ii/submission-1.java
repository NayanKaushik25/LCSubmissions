public class Solution {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> combo=new ArrayList<>();
    private void dfs(int[] nums,int i,int balance) {
        if(i>=nums.length && balance==0) {
            res.add(new ArrayList<>(combo));
            return;
        }
        if (i>=nums.length || balance<0) {
            return;
        }
        combo.add(nums[i]);
        dfs(nums,i+1,balance-nums[i]);
        combo.remove(combo.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]) {
            i=i+1;
        }
        dfs(nums,i+1,balance);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }
}