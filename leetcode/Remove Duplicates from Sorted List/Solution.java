/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
	public static class ListNode {
		int val;
    	ListNode next;
      	ListNode(int x) { 
      		val = x; 
      	}
 	}
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast)
    }
}