/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //Step 1: Define carry, temp value
        int carry = 0, temp = 0, value = 0;
        
        //Step 2: Define temp listnode
        ListNode sum = new ListNode(0);
        
        //Step 3: Define tail reverse of list node
        ListNode reverse = sum;
        
        //Step 4: While loop, till both goes empty
        while(l1 != null || l2 != null || carry != 0){
            //Step 5: Update the value and set to next element
            temp = carry;
            if(l1 != null){
                temp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }
            //Step 6: Set the carry and new node
            carry = temp / 10;
            value = temp % 10;
            
            //Step 7: Create a next node
            reverse.next = new ListNode(value);
            reverse = reverse.next;
        }
        
        //Step 7: Return temp's next 
        return sum.next;
    }
}