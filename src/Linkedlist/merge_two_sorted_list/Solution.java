package Linkedlist.merge_two_sorted_list;

import Linkedlist.ListNode;

/**
 * Merge two sorted linked lists and return it as a sorted linked list.
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // initialize head of returning linkedlist
        ListNode merge = new ListNode(0);
        // initialize current node of returning list
        ListNode cur = merge;


        // loop through the two lists and compare the values of the current nodes
        while ((list1 != null) || (list2 != null)) {
            // if list1 is null, add the value of list2 to the returning list
            if (list1 == null) {
                cur.next = new ListNode(list2.val);
                cur = cur.next;
                list2 = list2.next;
            }
            // if list2 is null, add the value of list1 to the returning list
            else if (list2 == null) {
                cur.next = new ListNode(list1.val);
                cur = cur.next;
                list1 = list1.next;
            }
            // if the value of list1 is less than or equal to the value of list2,
            // add the value of list1 to the returning list
            else if (list1.val <= list2.val) {
                cur.next = new ListNode(list1.val);
                cur = cur.next;
                list1 = list1.next;
            }
            // if the value of list2 is less than the value of list1,
            // add the value of list2 to the returning list
            else {
                cur.next = new ListNode(list2.val);
                cur = cur.next;
                list2 = list2.next;
            }
        }
        // return the head of the returning list
        return merge.next;
    }
}
