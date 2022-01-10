package January2022;

import Dhiraj.ListNode;

import java.util.ArrayList;

public class LinkedListRandomNode {
    private ArrayList<Integer> arr = new ArrayList<>();
    public LinkedListRandomNode(ListNode head) {
        while(head != null){
            this.arr.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int randomInt =(int) (Math.random() * this.arr.size());
        return this.arr.get(randomInt);
    }
}
