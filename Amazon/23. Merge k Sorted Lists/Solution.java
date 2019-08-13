/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //Method 1: Merging 2 at a time
//     public ListNode mergeKLists(ListNode[] lists) {
        
//         //Step 0: Declare variables
//         ListNode result = null;
        
//         //Step 1: Edge cases
//         if(lists == null || lists.length == 0)
//             return result;
        
//         int len = lists.length;
//         if(len == 1)                    //Step 2a: If length of lists = 1
//             return lists[0];
//         else if(len >= 2)               //Step 2b: If length of lists >= 2
//             result = merge2Lists(lists[0], lists[1]);
        
        
//         //Step 3: If length is more than 2
//         for(int i = 2; i < len; i++){
//             result = merge2Lists(result, lists[i]);
//         }
//         return result; 
//     }
    
//     //Method 1: Function to merge 2 lists
//     public ListNode merge2Lists(ListNode n1, ListNode n2){
//         //Step 4: Edge cases
//         if(n1 == null)
//             return n2;
//         else if(n2 == null)
//             return n1;
        
//         ListNode partial_result;
//         //Step 5: Check the value and merge it with the results
//         if(n1.val <= n2.val){
//             partial_result = new ListNode(n1.val);
//             partial_result.next = merge2Lists(n1.next, n2);
//         }else {
//             partial_result = new ListNode(n2.val);
//             partial_result.next = merge2Lists(n1, n2.next);
//         }
        
//         return partial_result;
//     }
    
    //Method 2: Using heap / priorityQueue
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case
        if(lists == null || lists.length == 0)
            return null;
        
        // Define Queue
        Queue<ListNode> minheap = new PriorityQueue<ListNode>(
            lists.length,
            (n1, n2) -> Integer.compare(n1.val, n2.val)
        );
        
        ListNode result = new ListNode(-1);
        ListNode part = result;
        
        for(ListNode n: lists){
            if(n != null)
                minheap.add((n));
        }
        
        ListNode temp = null;
        // Removing the ascending node list and store the first element into result
        while(!minheap.isEmpty()){
            temp = minheap.remove();
            part.next = temp;
            part = part.next;
            if(temp.next != null)
                minheap.add(temp.next);
        }
        
        return result.next;
    }
}