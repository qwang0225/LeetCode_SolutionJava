package Linkedlist.addTwoNumQ2;
import Linkedlist.ListNode;

/**
 *  Add two non-negative integers represented by linked list
 *  The digits are stored in reverse order, and each of their nodes contains a single digit.
 *  Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize the head of the result list
        ListNode head = new ListNode(0);
        // Initialize the current node of the result list
        ListNode curr = head;
        // Initialize the carry
        int carry = 0;
        // Loop through the two lists
        while (l1 != null || l2 != null) {
            // Get the value of the current node of l1
            int x = (l1 != null) ? l1.val : 0;
            // Get the value of the current node of l2
            int y = (l2 != null) ? l2.val : 0;
            // Get the sum of the two values and the carry
            int sum = x + y + carry;
            // Update the carry
            carry = sum / 10;
            // Update the current node of the result list
            curr.next = new ListNode(sum % 10);
            // Update the current node of l1
            if (l1 != null) {
                l1 = l1.next;
            }
            // Update the current node of l2
            if (l2 != null) {
                l2 = l2.next;
            }
            // Update the current node of the result list
            curr = curr.next;
        }
        // Check if the carry is not zero
        if (carry > 0) {
            // Update the current node of the result list
            curr.next = new ListNode(carry);
        }
        // Return the head of the result list
        return head.next;
    }

    public static void main (String[] args){
        // Test case 1
        Solution sol = new Solution();
        // Initialize first number 243 as a linked list
        ListNode l1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1.next = l1_2;
        l1_2.next = l1_3;

        // Initialize second number 56 as a linked list
        ListNode l2 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        l2.next = l2_2;

        // Add the two numbers
        sol.addTwoNumbers(l1, l2);
        System.out.println(sol.addTwoNumbers(l1, l2).val == 7);
        System.out.println(sol.addTwoNumbers(l1, l2).next.val == 0);
        System.out.println(sol.addTwoNumbers(l1, l2).next.next.val == 4);

        // Test case 2
        // Initialize first number 0 as a linked list
        ListNode l3 = new ListNode(0);
        // Initialize second number 0 as a linked list
        ListNode l4 = new ListNode(0);
        // Add the two numbers
        sol.addTwoNumbers(l3, l4);
        System.out.println(sol.addTwoNumbers(l3, l4).val == 0);

        // Test case 3
        // Initialize first number 9 as a linked list
        ListNode l5 = new ListNode(9);
        // Initialize second number 8 as a linked list
        ListNode l6 = new ListNode(8);
        System.out.println(sol.addTwoNumbers(l5, l6).val == 7);
        System.out.println(sol.addTwoNumbers(l5, l6).next.val == 1);
    }
}
