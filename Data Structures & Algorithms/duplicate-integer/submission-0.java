class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i = 0; nums.length > i; i++) {
            if(s.contains(nums[i])) return true;
            else s.add(nums[i]);
        }

        return false;
    }
}