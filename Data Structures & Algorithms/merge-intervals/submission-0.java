class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        for(int[] interval : intervals) {
            if(result.isEmpty()) {
                result.add(interval);
            } else {
                int[] last = result.getLast();
                if(last[1] < interval[0]) { // complete overlap
                    result.add(interval);
                } else {
                    result.getLast()[0] = Math.min(interval[0], last[0]);
                    result.getLast()[1] = Math.max(interval[1], last[1]);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
