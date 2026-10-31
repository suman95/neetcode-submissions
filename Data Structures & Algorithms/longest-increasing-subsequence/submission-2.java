class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        int result = 1;
        for(int i = 0 ; i < nums.length ; i++) {
            LIS[i] = 1;
        }
        for(int i = nums.length - 2; i >= 0 ; i--) {
            int curr_max = LIS[i];
            for(int j = i+1 ; j < nums.length ; j++) {
                if(nums[i] < nums[j]) {
                    curr_max = Math.max(curr_max, 1 + LIS[j]);
                }
            }
            LIS[i] = curr_max;
            result = Math.max(result, LIS[i]);
        }
        return result;
    }
}
