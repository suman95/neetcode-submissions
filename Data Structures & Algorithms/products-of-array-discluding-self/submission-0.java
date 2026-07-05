class Solution {
    public int[] productExceptSelf(int[] nums) {
        int  countZero = 0;
        int product = 1;
        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] != 0) product*=nums[i];
            else countZero += 1;
            res[i] = 0;
        }
        if(countZero > 1) return res;
        else if(countZero == 1){
            for(int i = 0 ; i < nums.length ; i++) {
                if(nums[i] == 0) {
                    res[i] = product;
                }
            }
            return res;
        }
        for(int i = 0 ; i < nums.length ; i++) {
            res[i] = product/nums[i];
        }
        return res;
    }
}  
