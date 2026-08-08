class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0 ; i <= n; i++) {
            int curr_height = i==n ? 0 : heights[i];
            while (!s.isEmpty() && curr_height < heights[s.peek()]) {
                int height = heights[s.pop()];
                int right = i;
                int left = s.isEmpty() ? -1 : s.peek();
                int width = right - left - 1;
                maxArea = Integer.max(height*width,maxArea);
            }
            s.push(i);
        }
        return maxArea; 
    }
}
