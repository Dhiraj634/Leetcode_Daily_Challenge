package January2022;

import java.util.Arrays;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = -1;
        for(int[] wealth : accounts){
            int sum = Arrays.stream(wealth).sum();
            max = Math.max(max, sum);
        }
        return max;
    }
}
