package January2022;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }
            while(stack.size() > 0){
                if(heights[stack.peek()] > heights[i]){
                    right[stack.pop()] = i;
                }else{
                    break;
                }
            }
            stack.push(i);
        }
        while(stack.size() > 0){
            right[stack.pop()] = n;
        }
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(i);
            }
            while(stack.size() > 0){
                if(heights[stack.peek()] > heights[i]){
                    left[stack.pop()] = i;
                }else{
                    break;
                }
            }
            stack.push(i);
        }
        while(stack.size() > 0){
            left[stack.pop()] = -1;
        }
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(left));
        int max = -1;
        for(int i=0;i<n;i++){
            max = Math.max((right[i] - left[i] -1) * heights[i], max);
        }
        return max;

    }
}
