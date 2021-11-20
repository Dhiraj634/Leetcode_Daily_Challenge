package Dhiraj;

public class SingleElementInSortedArray {

	public int singleNonDuplicate(int[] nums) {
		int len = nums.length;
		if(len == 1)return nums[0];
		int index =  divideAndCheckRecursive(nums,0,len-1);
		return nums[index];
	}
	/**
	 * All Other numbers are in pair so after breaking the array in two parts
	 * we will know which part has the number not repeated twice since that subarray will have odd length.
	 * */
	private int divideAndCheckRecursive(int[] nums, int start, int end){
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
			 temp1 = divideAndCheckRecursive(nums, start,mid);
			 temp2 = divideAndCheckRecursive(nums,mid+1,end);
		}else if(nums[mid] == nums[mid +1]){
			temp1 = divideAndCheckRecursive(nums, start,mid-1);
			temp2 = divideAndCheckRecursive(nums,mid,end);
		}else{
			return mid;
		}
		if(temp1 <0 && temp2 <0){
			return -1;
		}else{
			return (temp1 >= 0) ? temp1 : temp2;
		}
	}

	/**
	 * Recursive Approach for the above Solution so the space complexity is reduced here which was more because of recursion.
	 * */
	private int divideAndCheckIterative(int[] nums){
		int start = 0, end = nums.length - 1;
		int index = -1;
		while(start!=end){
			int mid = (start + end)/2;
			if(nums[mid] == nums[mid+1]){
				if((end - mid + 1)%2 ==0){
					end = mid - 1;
				}else{
					start = mid;
				}
			}else if(nums[mid] == nums[mid-1]){
				if((mid - start + 1)%2 ==0){
					start = mid + 1;
				}else{
					end = mid;
				}
			}else{
				index = mid;
				break;
			}
		}
		if(index ==-1)index = start;
		return index;
	}
}
