package Dhiraj;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next ==null){
			return head;
		}
		ListNode lo = head;
		ListNode le = head.next;
		boolean even = true;
		ListNode p =head.next;
		while(p!=null){
			if(even){
				p = p.next;
				even =false;
			}else{
				ListNode tempNode =lo.next;
				ListNode tempnode2 =p.next;
				lo.next = p;
				le.next = p.next;
				p.next = tempNode;
				lo= lo.next;
				le=le.next;
				p=tempnode2;
				even=true;
			}
		}
		return head;

	}
}
