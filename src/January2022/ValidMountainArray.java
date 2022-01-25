package January2022;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if(arr.length <3) return false;
        int leftIndex = 0;
        int i = 1;
        while(i < arr.length && arr[i] > arr[i-1]){
            leftIndex = i;
            i++;
        }
        if(leftIndex == arr.length - 1) return false;
        int rightIndex = arr.length - 1;
        i = arr.length - 2;
        while(i >=0 && arr[i] > arr[i+1]){
            rightIndex = i;
            i--;
        }
        if(rightIndex == 0) return false;
        return leftIndex == rightIndex;
    }
}
