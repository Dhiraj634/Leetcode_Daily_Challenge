package Dhiraj;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((b,a) -> a[0]*a[0]+a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
		for(int i=0;i<k;i++){
			pq.add(points[i]);
		}
		for(int i=k;i<points.length;i++){
			int[] point = pq.peek();
			if(point[0]*point[0]+point[1]*point[1] > points[i][0]*points[i][0]+points[i][1]*points[i][1]){
				pq.poll();
				pq.add(points[i]);
			}
		}
		int[][] ans = new int[k][2];
		while(k-->0){
			ans[k] = pq.poll();
		}
		return ans;
	}
	/**
	 * Another Approach
	 *     public int[][] kClosest(int[][] points, int k) {
	 *         PriorityQueue<int[]> pq = new PriorityQueue<>((b,a) -> a[0]*a[0]+a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
	 *         for(int i=0;i<k;i++){
	 *             pq.add(points[i]);
	 *         }
	 *         for(int i=k;i<points.length;i++){
	 *             int[] point = pq.peek();
	 *             if(point[0]*point[0]+point[1]*point[1] > points[i][0]*points[i][0]+points[i][1]*points[i][1]){
	 *                 pq.poll();
	 *                 pq.add(points[i]);
	 *             }
	 *         }
	 *         int[][] ans = new int[k][2];
	 *         while(k-->0){
	 *             ans[k] = pq.poll();
	 *         }
	 *         return ans;
	 *     }
	 * */
}
