package January2022;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] startNum = new int[]{12,123,1234,12345,123456,1234567,12345678,123456789};
        int[] endNum = new int[]{89,789,6789,56789,456789,3456789,23456789,123456789};
        int[] add = new int[]{11,111,1111,11111,111111,1111111,11111111,111111111};
        int index = 0;
        for(int i=0;i<8;i++){
            if(low>=startNum[i] && low<= endNum[i]){
                index =i;
                break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int num = startNum[index];
        while(num <= high){
            if(num >= low)
                ans.add(num);
            num+= add[index];
            if(num > endNum[index]){
                index++;
                if(index == 8) break;
                num = startNum[index];
            }
        }
        return ans;

    }
}
