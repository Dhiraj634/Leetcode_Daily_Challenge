package Greedy;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    /**
     * Each time we are iterating through the String we are subtracting 1 from the digit which is non-zero
     * for example : 82734
     * 1st pass
     *  removed 11111,so now the num is 71623
     * 2nd pass
     *  removed 11111,so now the num is 60512
     * 3rd pass
     *  removed 10111,so now the num is 50401
     * 4th pass
     *  removed 10101,so now the num is 40300
     * 5th, 6th, 7th pass
     *  remove 10100, so now the num is 10000
     * 8th pass
     *  remove 10000,so now the num is 00000
     * So our answer is 8,since 8 passes
     * */
    public int minPartitions(String n) {
        int count = 1,ans= 0;
        char[] arr = n.toCharArray();
        while(count !=0 ){
            count = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i] != '0'){
                    count++;
                    arr[i]--;
                }
            }
            if(count > 0) ans++;
        }
        return ans;
    }
    /**
     * Now if we observe carefully the above solution, when we make a pass , each time we reduce the
     * digit by 1.
     * So the maximum number of pass we will have to make is the maximum digit in the string,
     * and that will be our answer.
     *
     * public int minPartitions(String n) {
     *    int ans= -1;
     *    for(int i=0;i<n.length();i++){
     *        ans= Math.max(ans,n.charAt(i)-'0');
     *    }
     *    return ans;
     * }
     *
     * */
}
