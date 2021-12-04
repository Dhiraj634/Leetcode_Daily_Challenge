package Greedy;

public class IncreasingTripletSequence {

	public boolean increasingTriplet(int[] nums) {
		return moreIntuitiveApproach(nums);
	}

	private boolean constantSpaceAlgo(int[] nums){
		// this is like filtering, if the value is less than first then it will be captured by first
		// if value is greater than first and less than second, then it will be captured by second
		// if the value is greater than both first and second then we have got our answer and we return
		int first = Integer.MAX_VALUE, second=Integer.MAX_VALUE;
		for(int num: nums){
			if(num <= first){
				first = num;
			}else if(num <=second){
				second = num;
			}else{
				return true;
			}
		}
		return false;
	}

	private boolean moreIntuitiveApproach(int[] nums){
		/**
		 * First check if there is any num less than the current one
		 * then  check if any num greater than the current num
		 * then iterate over each index and is both lessNumOnLeft and bigNumOnRight are true then return true
		 * else false
		 * */
		boolean[] lessNumOnLeft = new boolean[nums.length];
		boolean[] bigNumberOnRight = new boolean[nums.length];
		int min = nums[0];
		for(int i=0;i<nums.length;i++){
			if(nums[i]>min){
				lessNumOnLeft[i] = true;
			}else{
				min = nums[i];
			}
		}
		int max = nums[nums.length - 1];
		for(int i=nums.length-1;i>=0;i--){
			if(nums[i]<max){
				bigNumberOnRight[i] = true;
			}else{
				max = nums[i];
			}
		}

		for(int i=0;i<nums.length;i++){
			if(lessNumOnLeft[i] && bigNumberOnRight[i]) return true;
		}
		return false;
	}

}
