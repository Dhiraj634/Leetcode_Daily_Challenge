package January2022;

import java.util.Arrays;

public class MinNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        // Made mistake here since if a[0]=Integer.MIN_VALUE then doing a[0]-something will give wrong result
        /**
         * You can use this as well as custom comparator
         * (a,b)-> a[0] < b[0] ? -1 : 1
         * Arrays.sort(points, (a,b)-> a[0] < b[0] ? -1 : 1);
         * */
        Arrays.sort(points, (a,b)->Integer.compare(a[0],b[0]));
        int start = points[0][0];
        int end = points[0][1];
        int count = 0;
        for(int[] point: points){
            if(point[0] <= end){
                start = Math.max(start, point[0]);
                end = Math.min(end, point[1]);
            }else{
                start = point[0];
                end = point[1];
                count++;
            }
        }
        count++;
        return count;
    }
}
