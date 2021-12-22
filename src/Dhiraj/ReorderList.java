package Dhiraj;

public class ReorderList {
	/**
	 * Time = O(n)
	 * Space = O(1)
	 * */
	public void reorderList(ListNode head) {
		ListNode temp = head, temp2 = null;
		int len = 0;
		while(temp!=null){
			len++;
			temp = temp.next;
		}
		int traverse = (len-1)/2;
		temp = head;
		while(traverse-- > 0){
			temp = temp.next;
		}
		ListNode secondHead = temp.next;
		temp.next = null;
		secondHead = reverseLinkedList(secondHead);
		while(secondHead !=null){
			temp = head.next;
			temp2 = secondHead.next;
			head.next = secondHead;
			secondHead.next = temp;
			head = temp;
			secondHead=temp2;
		}
	}
	private ListNode reverseLinkedList(ListNode head){
		ListNode prev= null, curr = head, next = null;
		while(curr !=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}
		return prev;
	}
	/**
	 * Second Approach
	 * Time = O(n)
	 * Space = O(n)
	 *
	 * public void reorderList2(ListNode head) {
	 * 		Deque<ListNode> dq= new ArrayDeque<>();
	 * 		while(head!=null){
	 * 			dq.addLast(head);
	 * 			head = head.next;
	 *                }
	 * 		ListNode dummy = new ListNode();
	 * 		ListNode tempDummy = dummy;
	 * 		boolean turn = true;
	 * 		while(!dq.isEmpty()){
	 *
	 * 			tempDummy.next = turn ? dq.removeFirst() : dq.removeLast();
	 * 			turn = !turn;
	 * 			tempDummy = tempDummy.next;
	 *        }
	 * 		tempDummy.next = null;* 	}
	 * */
}
