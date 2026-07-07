class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            s.add(nums[i]);
        }
        for(int i = 0 ; i < nums.length ; i++) {
            if(!s.contains(nums[i]-1)) {
                int temp = nums[i];
                int size = 0;
                while(s.contains(temp)) {
                    size+=1;
                    temp+=1;
                }
                if(res < size) res = size;
            }
        }
        return res;
    }
}
