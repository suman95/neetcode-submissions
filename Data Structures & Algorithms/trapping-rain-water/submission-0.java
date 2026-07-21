class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] lgreat = new int[size];
        int[] rgreat = new int[size];
        int res = 0;
        lgreat[0] = height[0];
        for(int i = 1 ; i < size ; i++) lgreat[i] = Math.max(lgreat[i-1],height[i]);
        rgreat[size-1] = height[size-1];
        for(int i = size-2 ; i > -1 ; i--) rgreat[i] = Math.max(rgreat[i+1] , height[i]);
        for(int i = 0 ; i < size ; i++) {
            res += (Math.min(lgreat[i],rgreat[i]) - height[i]);
        }
        return res;
    }
}
