/* IBM ASSESSMENT Q2
You are given a list of time intervals. each interval has a start point and an end point.
 Two intervals are considered non-overlapping if one ends before(or eactly when) the other begins.
  Find the largest number of non-overlapping intervals you can choose. example l=[3,4,5], r=[5,9,8] output 2 */

  import java.util.*;

public class Solution {

    public static int getMaxDisjointIntervals(List<Integer> l, List<Integer> r) {
        
        int n = l.size();
        
        List<int[]> intervals = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            intervals.add(new int[]{l.get(i), r.get(i)});
        }
        
        // Sort by end time
        intervals.sort((a, b) -> a[1] - b[1]);
        
        int count = 0;
        int lastEnd = -1;
        
        for(int[] interval : intervals){
            
            if(interval[0] >= lastEnd){
                count++;
                lastEnd = interval[1];
            }
        }
        
        return count;
    }
}

Total → O(n log n)
Space → O(n)