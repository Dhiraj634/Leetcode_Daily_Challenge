package January2022;

import java.util.Stack;

public class MaximumScoreOfAGoodArray {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] right = new int[n];
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }
            while(stack.size() > 0){
                if(nums[stack.peek()] > nums[i]){
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
                if(nums[stack.peek()] > nums[i]){
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


        int ans = nums[k] * (right[k] - left[k] - 1);
        for(int i=k-1;i>=0;i--){
            if(right[i] > k){
                int temp = (right[i] - left[i] - 1) * nums[i];
                if(temp >= ans){
                    ans = temp;
                }
            }
        }

        for(int i=k+1;i<n;i++){
            if(left[i] < k){
                int temp = (right[i] - left[i] - 1) * nums[i];
                if(temp >= ans){
                    ans = temp;
                }
            }
        }
        return ans;
    }
}
