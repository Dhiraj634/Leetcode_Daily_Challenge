package Greedy;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * This can be made single pass , because when we are going from left to right then we already know the
     * left minimum. But now supposes there comes a value that want to replace the top of the stack so in that case
     * for the top of the stack the element that is replacing it, is the first smaller element on the right , hence we get our right smaller element.
     * Had there been any other smaller element before that then the stack's top element would not have been there.
     * */
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

    private int largestRectangleAreaSinglePass(int[] heights){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = -1;
        for(int i=0;i<heights.length;i++){
            while(stack.peek() !=-1 && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];
                int right = i, left = stack.peek();
                ans = Math.max(ans, (right - left -1) * height);
            }
            stack.push(i);
        }
        int index = heights.length;
        while(stack.peek()!=-1){
            int height = heights[stack.pop()];
            int  left = stack.peek();
            ans = Math.max(ans, (index - left -1) * height);
        }
        return ans;
    }
}
