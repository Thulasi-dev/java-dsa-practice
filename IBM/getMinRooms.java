/* IBM ASSESMENT Q1

you are given a list of n meeting, where each meeting is represented by a start time and an end time.
 your task is to determine the minimum number of meeting rooms require so that: no two meetings in the 
 same room overlap . A meeting that ends at time t and another that starts at time t do not overlap
  and can use the same room. returm the minimum number of rooms needed to schedule all meetings. 
   example n=5 meeting timings=[[1,4],1,5],5,6,[6,10],[7,9] output 2 
   
   Optimal Approach (Sorting + Two Pointers)
Step 1:

Separate all:

Start times

End times

Step 2:

Sort both arrays

Step 3:

Use two pointers:

If start < end → need new room

If start >= end → one meeting finished → reuse room

⚠ Important:
You clearly mentioned:

If one ends at time t and another starts at t → NOT overlapping
So condition must be:
start < end → new room
start >= end → reuse room*/

import java.util.*;

public class Solution {

    public static int getMinRooms(List<List<Integer>> meetingTimings) {
        
        int n = meetingTimings.size();
        
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i = 0; i < n; i++){
            start[i] = meetingTimings.get(i).get(0);
            end[i] = meetingTimings.get(i).get(1);
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms = 0;
        int maxRooms = 0;
        
        int i = 0, j = 0;
        
        while(i < n){
            
            if(start[i] < end[j]){ 
                rooms++;       // need new room
                maxRooms = Math.max(maxRooms, rooms);
                i++;
            } else {           
                rooms--;       // meeting ended, free room
                j++;
            }
        }
        
        return maxRooms;
    }
}

Total → O(n log n)
Space → O(n)