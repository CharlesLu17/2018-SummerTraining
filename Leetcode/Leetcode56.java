Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        for (int i=0; i<intervals.size()-1; i++) {
            for (int j=0; j<intervals.size()-1-i; j++) {
                if (intervals.get(i).start> intervals.get(i+1).start) {
                    Interval temp =intervals.get(i);
                    intervals.set(i,intervals.get(i+1));
                    intervals.set(i+1,temp);
                }
            }
        }
        for (int i=0; i<intervals.size()-1; i++) {
            if (intervals.get(i).end>= intervals.get(i+1).end) {
                intervals.remove(i+1);
            }
            if (intervals.get(i).end>= intervals.get(i+1).start) {
                intervals.get(i).end = Math.max(intervals.get(i+1).end, intervals.get(i).end);
                intervals.remove(i+1);
            }
        }
        return intervals;
    }
}
