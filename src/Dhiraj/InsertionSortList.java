package Dhiraj;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode node= head.next, prevNode = head;
		int sortedLen = 1;
		if(head.next == null) return head;
		while(node != null){
			// Storing the next Node That will be processed
			ListNode nextNode = node.next;
			// Removal of the node that we want to put into sorted list
			prevNode.next = node.next;
			//Inserting into the sorted list
			ListNode[] ans = insertIntoLinkedList(head, node, sortedLen,prevNode);
			sortedLen++;
			head = ans[0];
			prevNode = ans[1];
			node = nextNode;
		}
		return head;
	}
	private ListNode[] insertIntoLinkedList(ListNode head, ListNode node, int sortedLen, ListNode lastNode){
		ListNode temp = head, prevNode = null;
		while(sortedLen > 0){
			if(temp.val > node.val){
				break;
			}
			sortedLen--;
			prevNode = temp;
			temp = temp.next;
		}
		// Case of Inserting in the beginning
		if(temp == head){
			node.next = head;
			head = node;
		}else{
			node.next = prevNode.next;
			prevNode.next = node;
		}
		// case of checking the lastNode
		if(sortedLen == 0){ // Means that the node is inserted at the last and lastNode is updated
			return new ListNode[]{head, node};
		}else{ // Means that the node is inserted somewhere in middle and the last and lastNode is not updated
			return new ListNode[]{head,lastNode};
		}
	}
}
