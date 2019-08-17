/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        temp.next = null;
        
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);
        
        return merge(left_side, right_side);
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode sorted_temp = new ListNode(0);
        ListNode current_node = sorted_temp;
        
        while(left != null && right != null){
            if(left.val < right.val){
                current_node.next = left;
                left = left.next;
            }else{
                current_node.next = right;
                right = right.next;
            }
            current_node = current_node.next;
        }
        
        if(left != null)
            current_node.next = left;
        
        if(right != null)
            current_node.next = right;
        
        return sorted_temp.next;
    }
}