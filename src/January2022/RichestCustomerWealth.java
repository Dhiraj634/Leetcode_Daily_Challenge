package January2022;

import java.util.Arrays;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
//        return Arrays.stream(accounts).map(input -> Arrays.stream(input).sum()).mapToInt(Integer::intValue).max().getAsInt();
//        return Arrays.stream(accounts).map(input -> Arrays.stream(input).sum()).reduce(-1, Math::max);
        int max = -1;
        for(int[] wealth : accounts){
            int sum = Arrays.stream(wealth).sum();
            max = Math.max(max, sum);
        }
        return max;
    }
}
