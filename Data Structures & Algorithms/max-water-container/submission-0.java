class Solution {
    public int maxArea(int[] heights) {
       int i = 0, j = heights.length-1, tmp_ar;
        int res = Integer.MIN_VALUE;
        while(i < j) {
            if(heights[i] > heights[j]) {
                tmp_ar = heights[j]*(j-i);
                j--;
            } else  {
                tmp_ar = heights[i]*(j-i);
                i++;
            }
            res = Math.max(res,tmp_ar);
        }
        return res; 
    }
}
