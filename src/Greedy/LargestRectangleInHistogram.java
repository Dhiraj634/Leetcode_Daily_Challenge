package Greedy;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] leftHeight = new int[heights.length];
        int[] rightHeight = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty())leftHeight[i]=-1;
            else leftHeight[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty())rightHeight[i]=heights.length;
            else rightHeight[i] = stack.peek();
            stack.push(i);
        }
        int ans = -1;
        for(int i=0;i<heights.length;i++){
            int tempArea = (rightHeight[i] - leftHeight[i] - 1 ) * heights[i];
            ans = Math.max(ans, tempArea);
        }
        return ans;
    }
}
