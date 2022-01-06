package January2022;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        // Optimized Code
        // TC: O(nlogn)
        Arrays.sort(trips, (a,b) -> a[1]==b[1] ? a[2]-b[2] : a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int[] trip: trips){
            while(!pq.isEmpty() && pq.peek()[2] <= trip[1]){
                capacity+= pq.poll()[0];
            }
            if(capacity < trip[0]){
                return  false;
            }
            capacity-=trip[0];
            pq.add(trip);

        }
        return true;

        // Brute force approach
        // TC : O(n^2)
        /*
            Arrays.sort(trips, (a,b) -> a[1]==b[1] ? a[2]-b[2] : a[1]-b[1]);
            boolean[] passengerLeft = new boolean[trips.length];
            int index = 0;
            for(int[] trip: trips){
                for(int i=0;i<index;i++){
                    if(trips[i][2] <= trip[1] && !passengerLeft[i]){
                        capacity+=trips[i][0];
                        passengerLeft[i] = true;
                    }
                }
                if(capacity < trip[0]){
                    return  false;
                }
                capacity-=trip[0];
                index++;

            }
            return true;
        */

    }
}
