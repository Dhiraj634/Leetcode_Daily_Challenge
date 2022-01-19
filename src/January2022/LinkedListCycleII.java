package January2022;

import Dhiraj.ListNode;

public class LinkedListCycleII {
    /**
     * TC : O(N)
     * SC : O(1)
     * */
    public ListNode detectCycle(ListNode head) {
        int N = 1000000;
        ListNode ans = null,tempHead=null;
        tempHead = head;
        while(head!=null){
            if(head.val < 0 && head.val <= -N){
                ans = head;break;
            }else if(head.val >=0 && head.val >= N){
                ans = head;break;
            }

            if(head.val < 0) head.val-=N;
            else{
                head.val+=N;
            }
            head = head.next;
        }
        while(tempHead != ans && tempHead.val >=-100000 && tempHead.val <=100000){
            if(tempHead.val < 0) tempHead.val+=N;
            else tempHead.val-=N;
        }
        return ans;
    }

    /**
     * TC : O(N)
     * SC : O(N)
     * public ListNode detectCycle(ListNode head) {
     *         HashSet<ListNode> map = new HashSet<>();
     *         while(head!=null){
     *             if(map.contains(head)) return head;
     *             map.add(head);
     *             head = head.next;
     *         }
     *         return null;
     *     }
     * */

}
