package January2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BurstBalloons {
    Map<String, Integer> dp = new HashMap<>();
    public int maxCoins(int[] nums) {
        nums = Arrays.stream(nums).filter(a -> a >0).toArray();
        StringBuilder sb = new StringBuilder();
        boolean[] included = new boolean[nums.length];
        return getMax(nums, included);
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
}
