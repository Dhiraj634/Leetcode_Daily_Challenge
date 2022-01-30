package January2022;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,0,n -1);
        reverse(nums,0,k-1);
        reverse(nums, k,n-1);
    }
    private void reverse(int[] num, int start, int end){
        int i = start, j = end;
        while(i<j){
            num[i]^=num[j];
            num[j]^=num[i];
            num[i]^=num[j];
            i++;j--;
        }
    }
}
