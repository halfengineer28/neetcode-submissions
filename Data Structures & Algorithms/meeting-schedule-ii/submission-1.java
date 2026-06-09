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
        Collections.sort(intervals, Comparator.comparing(i -> i.start));
       PriorityQueue<Integer> pq = new PriorityQueue<>();

       for (int i = 0; i < intervals.size(); i++){
            Interval i1 = intervals.get(i);
            if (!pq.isEmpty() && pq.peek() <= i1.start){
                pq.poll();
            }

            pq.add(i1.end);
            
       }
       return pq.size();
    }
}
