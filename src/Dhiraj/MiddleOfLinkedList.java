package Dhiraj;

public class MiddleOfLinkedList {
	public ListNode middleNode(ListNode head) {
		if(head.next == null) return head;
		ListNode slowRunner = head, fastRunner = head;
		/** First condition i.e. fastRunner!=null is used for even cases and second condition for the odd cases*/
		while(fastRunner!=null && fastRunner.next!=null){
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next.next;

		}
		return slowRunner;
	}
}
