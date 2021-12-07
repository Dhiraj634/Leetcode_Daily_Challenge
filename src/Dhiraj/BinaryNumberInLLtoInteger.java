package Dhiraj;

public class BinaryNumberInLLtoInteger {
	/**
	 * Time Complexity : O(N) -> since we are iterating through the whole Linked List
	 * Space Complexity : O(N) -> since we are storing the linked list node value to the StringBuilder
	 * */

	public int getDecimalValue(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while(head!=null){
			sb.append(head.val);
			head = head.next;
		}
		int num = 0;
		for(int i=0;i<sb.length();i++){
			num+= (sb.charAt(sb.length()-1-i)-'0') * Math.pow(2,i);
		}
		return num;
	}
	/**
	 * Another solution
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 *
	 *  public int getDecimalValue(ListNode head) {
	 *      int num = 0;
	 * 		while(head!=null){
	 * 			num = num << 1;
	 *          num = num | head.val;
	 * 			head = head.next;
	 *      }
	 * 		return num;
	 * }
	 *
	 * */
}
