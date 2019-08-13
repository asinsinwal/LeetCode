/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //Step 1: Set a ListNode to 3rd one
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        
        //Step 2: Check for which list has the least value
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }
        //Step 3: Check if any of the list is not empty
        if(l1 != null)
            result.next = l1;
        else if(l2 != null)
            result.next = l2;
        
        //Step 4: Return head
        return temp.next;
    }
}