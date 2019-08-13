/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // Array 2D
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode temp_head = head;
        
        while(head != null){
            size++;
            head = head.next;
        }
        
        head = temp_head;
        
        // Set the 2D array for the portions we want rotations
        int[][] array = new int[size/k][k];
        
        for(int i = 0; i < size/k; i++){
            for(int j = 0; j < k; j++){
                array[i][j] = head.val;
                head = head.next;
            }
        }
        
        // Copy the reverse value back into linkedlist;
        head = temp_head;
        
        for(int a = 0; a < size/k; a++){
            for(int b = k-1; b >= 0; b--){
                head.val = array[a][b]; 
                head = head.next;
            }
        }
        
        return temp_head;
    }
}