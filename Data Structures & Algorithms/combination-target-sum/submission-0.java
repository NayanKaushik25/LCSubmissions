public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> combo = new ArrayList<>();

    private void dfs(int[] nums, int i, int balance) {
        if (i >= nums.length && balance == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }
        if (i >= nums.length || balance < 0) {
            return;
        }
        combo.add(nums[i]);
        dfs(nums, i, balance - nums[i]);
        combo.remove(combo.size() - 1);
        dfs(nums, i + 1, balance);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target);
        return res;
    }
}