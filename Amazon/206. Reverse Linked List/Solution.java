/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // Method 1: Iteratively
//     public ListNode reverseList(ListNode head) {
//         ListNode previous = null;
//         ListNode current = head;
//         ListNode temp = null;
        
//         while(current != null){
//             temp = current.next;
//             current.next = previous;
//             previous = current;
//             current = temp;
//         }
        
//         return previous;
//     }
    
    // Method 2: Recursively
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return result;
    }
}