package Linkedlist.ListCycle;
import Linkedlist.ListNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the
 * list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is
 * connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        // hashmap to count times of occurence of each node while looping through the list
        Map<ListNode, Integer> count = new HashMap<>();

        // current listnode while looping through the list
        ListNode cur = head;

       // loop through the list and count the times of occurence of each node
        while (cur != null){
            // if the node has been seen before, return true
            count.put(cur, count.getOrDefault(cur, 0) + 1);
            if (count.get(cur) > 1){
                return true;
            }
            cur = cur.next;
        }
        return false;


    }
}
