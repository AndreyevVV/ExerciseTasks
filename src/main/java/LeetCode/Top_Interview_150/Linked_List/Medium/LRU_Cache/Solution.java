package LeetCode.Top_Interview_150.Linked_List.Medium.LRU_Cache;

import java.util.HashMap;

public class Solution {

    class LRUCache {

        private int capacity;
        private HashMap<Integer, Node> cache = new HashMap<>();
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                moveToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                if (cache.size() >= capacity) {
                    Node toRemove = tail.prev;
                    removeNode(toRemove);
                    cache.remove(toRemove.key);
                }
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                cache.put(key, newNode);
                addToHead(newNode);
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        class Node {
            int key;
            int value;
            Node prev;
            Node next;
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
