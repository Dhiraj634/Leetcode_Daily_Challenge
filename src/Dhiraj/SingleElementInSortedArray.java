package Dhiraj;

public class SingleElementInSortedArray {

	public int singleNonDuplicate(int[] nums) {
		int len = nums.length;
		if(len == 1)return nums[0];
		int index =  divideAndCheck(nums,0,len-1);
		return nums[index];
	}
	/**
	 * All Other numbers are in pair so after breaking the array in two parts
	 * we will know which part has the number not repeated twice since that subarray will have odd length.
	 * */
	private int divideAndCheck(int[] nums, int start, int end){
		if(start == end){
			return start;
		}
		/**
		 * If len of the array is even then return since the single will not be there
		 * */
		if((end - start + 1)%2 ==0 ){
			return -1;
		}
		int mid = (start + end) / 2;
		int temp1 = -1,temp2 =-1;
		if(nums[mid] == nums[mid-1]){
			 temp1 = divideAndCheck(nums, start,mid);
			 temp2 = divideAndCheck(nums,mid+1,end);
		}else if(nums[mid] == nums[mid +1]){
			temp1 = divideAndCheck(nums, start,mid-1);
			temp2 = divideAndCheck(nums,mid,end);
		}else{
			return mid;
		}
		if(temp1 <0 && temp2 <0){
			return -1;
		}else{
			return (temp1 >= 0) ? temp1 : temp2;
		}
	}
}
