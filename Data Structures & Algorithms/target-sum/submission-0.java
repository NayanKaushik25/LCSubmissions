class Solution {
    Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();

    private int dfs(int[] nums, int target, int idx, int total) {
        if (idx == nums.length) {
            return total == target ? 1 : 0;
        }
        if (dp.containsKey(idx) && dp.get(idx).containsKey(total)) {
            return dp.get(idx).get(total);
        }
        int ans = dfs(nums, target, idx + 1, total + nums[idx]) + dfs(nums, target, idx + 1, total - nums[idx]);
        if (!dp.containsKey(idx)) {
            dp.put(idx, new HashMap<>());
        }
        dp.putIfAbsent(idx, new HashMap<>());
        dp.get(idx).put(total, ans);
        return ans;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }
}