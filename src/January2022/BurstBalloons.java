package January2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BurstBalloons {
    Map<String, Integer> dp = new HashMap<>();
    public int maxCoins(int[] nums) {
        nums = Arrays.stream(nums).filter(a -> a >0).toArray();

        // DP approach, similar to matrix chain multiplication
        // Watch the video for explanation https://www.youtube.com/watch?v=YzvF8CqPafI
        return maxCoinsDp(nums);



        // Recursive Approach giving TLE
        // return getMax(nums, new boolean[nums.length]);
    }
    private int getMax(int[] arr, boolean[] included){
        StringBuilder sb = new StringBuilder();
        int index=0;
        int[][] list = new int[arr.length][2];
        for(int i=0;i<included.length;i++){
            if(!included[i]) {
                sb.append(arr[i]).append(',');
                list[index][0]=arr[i];
                list[index++][1]=i;
            }
        }
        if(index == 1) return list[index-1][0];
        if(dp.containsKey(sb.toString())) return dp.get(sb.toString());
        int tempMax = -1;
        for(int i=0;i<index;i++){

            int val = list[i][0];
            val = val * (i == 0 ? 1 : list[i-1][0]);
            val = val * (i == index-1 ? 1 : list[i+1][0]);

            included[list[i][1]]=true;
            val+=getMax(arr,included);
            included[list[i][1]]=false;
            tempMax = Math.max(val,tempMax);
        }
        dp.put(sb.toString(), tempMax);
        return tempMax;
    }

    private int maxCoinsDp(int[] nums) {
        nums = Arrays.stream(nums).filter(a -> a >0).toArray();
        int n = nums.length;
        int dp[][] = new int[n][n];

        for(int gap = 0; gap < n ; gap++){
            for(int left = 0, right =gap; right < n ;left++,right++) {

                int max = -1;
                for(int k = left;k<=right;k++){
                    int leftVal = k ==left ? 0: dp[left][k-1];
                    int rightVal = k == right ? 0 : dp[k+1][right];
                    int val = (left == 0 ? 1 : nums[left-1]) * nums[k] * (right == n-1 ? 1 : nums[right+1]);
                    int total = leftVal + rightVal + val;
                    max = Math.max(total, max);
                }
                dp[left][right]=max;
            }
        }
        return dp[0][n-1];

    }
}
