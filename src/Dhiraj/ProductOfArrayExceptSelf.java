package Dhiraj;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
//		return segmentTreeApproach(nums);
		return leftAndRightCumulativeProductApproach(nums);
	}
	private int[] leftAndRightCumulativeProductApproach(int[] nums){
		int len= nums.length;
		int[] leftProduct = new int[len];
		int[] rightProduct = new int[len];
		leftProduct[0]=nums[0];
		rightProduct[len-1] = nums[len-1];
		int[] ans=new int[len];
		for(int i=1;i<len;i++){
			leftProduct[i]=(leftProduct[i-1]*nums[i]);
		}
		for(int i=len-2;i>=0;i--){
			rightProduct[i]=(rightProduct[i+1]*nums[i]);
		}
		for(int i=0;i<len;i++){
			if(i==0)ans[i]=rightProduct[i+1];
			else if(i==len-1)ans[len-1] = leftProduct[len-2];
			else {
				ans[i] = leftProduct[i-1] * rightProduct[i+1];
			}
		}
		return ans;
	}
	private int[] segmentTreeApproach(int[] nums){
		int len = nums.length;
		int segTree[] = new int[len*4];
		constructSegmentTree(segTree,nums,0,len-1,0);
		int[] ans = new int[len];
		for(int i=0;i<len;i++){
			int left=1,right =1;
			if(i==0){
				right = getProductFromRange(segTree,i+1,len-1,0,len-1,0);
			}else if(i==len-1){
				left = getProductFromRange(segTree,0,i-1,0,len-1,0);
			} else{
				left = getProductFromRange(segTree,0,i-1,0,len-1,0);
				right = getProductFromRange(segTree,i+1,len-1,0,len-1,0);
			}
			ans[i]= left* right;
		}
		return ans;
	}
	private int constructSegmentTree(int[] segTree, int[]nums,int start, int end,int treeIndex){
		if(start == end){
			segTree[treeIndex] = nums[start];
			return nums[start];
		}
		int mid = start+ (end - start)/2;
		int left = constructSegmentTree(segTree,nums,start,mid,treeIndex*2+1);
		int right = constructSegmentTree(segTree,nums,mid+1,end,treeIndex*2+2);
		segTree[treeIndex] = left * right;
		return segTree[treeIndex];
	}
	private int getProductFromRange(int[] segTree,int qs,int qe, int numStart,int numEnd,int treeIndex){
		if(numStart >= qs &&numEnd <= qe){
			return segTree[treeIndex];
		}
		if(numStart > qe || numEnd< qs){
			return 1;
		}
		int mid = (numStart + numEnd)/2;
		int temp1 =1,temp2=1;
//		if(qe <= mid){
//			temp1 = getProductFromRange(segTree,qs,qe,numStart,mid,treeIndex*2 +1);
//		}else if(qs >mid){
//			temp2 = getProductFromRange(segTree,qs,qe,mid+1,numEnd,treeIndex*2 +2);
//		}else{
			temp1 = getProductFromRange(segTree,qs,qe,numStart,mid,treeIndex*2 +1);
			temp2 = getProductFromRange(segTree,qs,qe,mid+1,numEnd,treeIndex*2 +2);
//		}

		return temp1 * temp2;
	}
}
