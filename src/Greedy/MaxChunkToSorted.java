package Greedy;

public class MaxChunkToSorted {
    public int maxChunksToSorted(int[] arr) {
        int start = 0, count = 0,min = arr[0], max = arr[0];
        for(int i=0;i<arr.length;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
            if(min == start && max == i){
                count++;
                start = i+1;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
        }
        return count;
    }
}
