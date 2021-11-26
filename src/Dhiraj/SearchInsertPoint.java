package Dhiraj;

public class SearchInsertPoint {
	public int searchInsert(int[] nums, int target) {
		int start = 0, end = nums.length-1;
		while(end >= start){
			int mid = (end + start) / 2;
			if(target == nums[mid]){
				return mid;
			}else if(nums[mid] > target) {
				end = mid -1;
			} else{
				start = mid+1;
			}
		}
		/**
		 * There can be two possibility while doing binary search
		 *
		 * NOTE: IN BOTH CASES IF WE FIND OUT THE MID WE GET MID = START
		 *
		 * case 1: end = start
		 * 		In this cases if you find out the mid it will be equal to start,
		 * 		So basically we are checking if the target element with start
		 * 		and if the element is less that mid i.e. start (which is equal to end) we do (end = mid - 1) and in doing so  end < start we break so start gives the index of the position of insert
		 * 		and if the element is more than mid i.e. start (which is equal to end)	we do (start = mid + 1) and in doing so  end < start we break so start gives the index of the position of insert
		 * case 2: end = start + 1
		 * 		In this cases if you find out the mid it will be equal to start,
		 * 		So basically we are checking if the target element with start
		 * 		and if the element is less that mid i.e. start (which is equal to end) we do (end = mid - 1) and in doing so  end  = start and we repeat the case 1 mentioned above
		 * 		and if the element is more than mid i.e. start (which is equal to end)	we do (start = mid + 1) and in doing so  end  = start and we repeat the case 1 mentioned above
		 *
		 * Hence we return start value as it will always point to the place of insert
		 *
		 * */
		return start;
	}
}
