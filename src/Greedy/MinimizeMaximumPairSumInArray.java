package Greedy;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = -1;
        int start = 0, end = nums.length-1;
        while(start< end){
            ans = Math.max(nums[start++]+nums[end--],ans);
        }
        return ans;
    }
}
