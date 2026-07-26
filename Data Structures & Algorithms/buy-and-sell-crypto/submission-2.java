class Solution {
    public int maxProfit(int[] prices) {
       int min = Integer.MAX_VALUE;
        int max = 0;
        for(int price : prices) {
            if(price < min) {
                min = Math.min(price,min);
            } else {
                int profit = price - min;
                max = Math.max(profit,max);
            }
        }
        return max; 
    }
}
