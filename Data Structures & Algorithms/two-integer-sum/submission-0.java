class Solution {
        public int[] twoSum(int[] nums,int target) {
            Map<Integer,Integer> hash=new HashMap<>();
            for(int i=0;i<nums.length;i++) {
                hash.put(nums[i],i);
            }
            for(int i=0;i<nums.length;i++) {
                int diff=target-nums[i];
                if(hash.containsKey(diff) && hash.get(diff) != i) {
                    return new int[]{i,hash.get(diff)};
                }
            }
            return new int[]{};
        }
}