package HashMap;

import java.util.Calendar;
import java.util.HashMap;

/*
Leetcode Q146.
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair
    to the cache. If the number of keys exceeds the capacity from this operation,
    evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {

    class DLinkedListNode{
        int key;
        int value;

        DLinkedListNode prev;
        DLinkedListNode next;
        public DLinkedListNode(){}
        public DLinkedListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, DLinkedListNode> cache;
    DLinkedListNode head;
    DLinkedListNode tail;

    private int size;
    private final int CAPACITY;

    public LRUCache(int capacity){
        this.CAPACITY = capacity;
        cache = new HashMap<>();
        head = new DLinkedListNode();
        tail = new DLinkedListNode();
        head.next = tail;
        tail.prev = head;

    }


    public int get(int key) {

        DLinkedListNode node = cache.get(key);

        if (node == null){
            return -1;
        }
        removeNode(node);
        moveToHead(node);
        return node.value;

    }

    private void moveToHead(DLinkedListNode node) {
        DLinkedListNode headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    private void removeNode(DLinkedListNode node) {
        DLinkedListNode prevNode = node.prev;
        DLinkedListNode afterNode = node.next;

        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }

    public void put(int key, int value) {
        DLinkedListNode node = cache.get(key);

        if (node == null){
            node = new DLinkedListNode(key, value);
            if (size == CAPACITY){
                DLinkedListNode tailPrev = tail.prev;
                removeNode(tailPrev);
                cache.remove(tailPrev.key);
                size--;
            }
            cache.put(key, node);
            moveToHead(node);
            size++;
        }
        else{
            node.value = value;
            removeNode(node);
            moveToHead(node);
        }

    }


}
