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

    /**
     * The concept behind this is that, we make partition at a point where all the elements on the left are smaller that all the elements of the right.
     * For this we calculate the max at each index from left till that index.
     * calculate the min from that index till the end
     * now if at any index leftMax[index] <= rightMin[index+1] we can do a partition
     * */
    private int anotherSolution(int[] arr) {
        int[] leftMax=new int[arr.length];    // this array stores the max value from 0 to ith index at ith index
        leftMax[0]=arr[0];
        int[] rightMin=new int[arr.length];   // this array stores the min value from i to arr.length-1 at ith index
        rightMin[arr.length-1]=arr[arr.length-1];
        for(int i=1;i<arr.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],arr[i]);
        }
        for(int i=arr.length-2;i>=0;i--){
            rightMin[i]=Math.min(rightMin[i+1],arr[i]);
        }

        // now we traverse in leftMax array and rightMin array and compare the ith value of leftMax to (i+1)th value of rightMin array
        // if we find leftMax[i] <= rightMin[i+1] , then it means all the elements from 0 to i is less then or equal to all the elelemts from i+1 to arr.length-1 , and it means if we sort the left and right part separatly then also we got a perfectly sorted array.

        int i=0;
        int count=0;  // count of number of partitions
        while(i<arr.length-1){
            if(leftMax[i]<=rightMin[i+1]){
                count++;
            }
            i++;
        }

        return count+1;        // the number of chunks is one more than the number of partitions

    }
}
