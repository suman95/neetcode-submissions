class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0 ; i < nums.length; i++) {
            m.put(nums[i], i);
        }
        for(int i = 0 ; i < nums.length; i++) {
            if(m.containsKey(target - nums[i]) && i != m.get(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                return res;
            }
        }
        return res;
    }
}
