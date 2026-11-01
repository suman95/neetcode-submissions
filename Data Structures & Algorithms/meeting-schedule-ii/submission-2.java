/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) {
                return 0;
            }
            int[] start = new int[intervals.size()];
            int[] end = new int[intervals.size()];
            for(int i = 0 ; i < intervals.size(); i++) {
                start[i] = intervals.get(i).start;
                end[i] = intervals.get(i).end;
            }
            Arrays.sort(start);
            Arrays.sort(end);
            int numRooms = 0;
            int maxRooms = 0;
            int startPointer = 0;
            int endPointer = 0;
            while(startPointer < intervals.size()) {
                if(start[startPointer] < end[endPointer]) {
                    numRooms++;
                    startPointer++;
                } else {
                    numRooms--;
                    endPointer++;
                }
                maxRooms = Math.max(maxRooms, numRooms);
            }
            return maxRooms;
    }
}
