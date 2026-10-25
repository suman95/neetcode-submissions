class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lower = 1;
        int upper = 0;
        for(int pile : piles) {
            upper = Math.max(pile, upper);
        }
        if(piles.length == h) {
            return upper;
        }
        int result = upper;
        while (lower <= upper) {
            int mid =  Math.ceilDiv((upper+lower), 2);
            int timeTaken = 0;
            for(int pile : piles) {
                timeTaken += Math.ceilDiv(pile,mid);
            }
            if(timeTaken <= h) {
                result = Math.min(mid,result);
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return result;
    }
}
