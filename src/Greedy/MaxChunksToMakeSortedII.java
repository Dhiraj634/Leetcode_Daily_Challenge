package Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MaxChunksToMakeSortedII {
    /** Replacing each arr elements to it's respective indexes, and those indexes should be according to the
     *  sorted arr.
     *  After that it is same as the Max chunk To Sorted Problem {@link MaxChunkToSorted}
     * */
    public int maxChunksToSorted(int[] arr) {
        int[] tempArr = Arrays.stream(arr).sorted().toArray();
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();
        for(int i=0;i<tempArr.length;i++){
            map.putIfAbsent(tempArr[i],new Stack<>());
            map.get(tempArr[i]).push(i);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]).pop();
        }
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
