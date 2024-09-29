package LeetCode.Daily_Challenge.Hard.All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    static class AllOne {
        private static class Node {
            int count;
            HashSet<String> keys;
            Node prev, next;

            Node(int count) {
                this.count = count;
                keys = new HashSet<>();
            }
        }

        private HashMap<String, Integer> countMap;
        private HashMap<Integer, Node> nodeMap;
        private Node head, tail;

        public AllOne() {
            countMap = new HashMap<>();
            nodeMap = new HashMap<>();
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }



        public void inc(String key) {
            if (!countMap.containsKey(key)) {
                countMap.put(key, 1);
                addKeyToNode(1, key);
            } else {
                int currentCount = countMap.get(key);
                countMap.put(key, currentCount + 1);
                moveKeyToNextNode(currentCount, key);
            }
        }

        public void dec(String key) {
            int currentCount = countMap.get(key);
            if (currentCount == 1) {
                countMap.remove(key);
                removeKeyFromNode(currentCount, key);
            } else {
                countMap.put(key, currentCount - 1);
                moveKeyToPrevNode(currentCount, key);
            }
        }

        public String getMaxKey() {
            return tail.prev == head ? "" : tail.prev.keys.iterator().next();
        }

        public String getMinKey() {
            return head.next == tail ? "" : head.next.keys.iterator().next();
        }

        private void addKeyToNode(int count, String key) {
            Node node = nodeMap.get(count);
            if (node == null) {
                node = new Node(count);
                nodeMap.put(count, node);
                insertNodeAfter(node, head);
            }
            node.keys.add(key);
        }

        private void moveKeyToNextNode(int currentCount, String key) {
            Node currentNode = nodeMap.get(currentCount);
            Node nextNode = currentNode.next;
            if (nextNode == tail || nextNode.count > currentCount + 1) {
                nextNode = new Node(currentCount + 1);
                nodeMap.put(currentCount + 1, nextNode);
                insertNodeAfter(nextNode, currentNode);
            }
            nextNode.keys.add(key);
            removeKeyFromNode(currentCount, key);
        }

        private void moveKeyToPrevNode(int currentCount, String key) {
            Node currentNode = nodeMap.get(currentCount);
            Node prevNode = currentNode.prev;
            if (prevNode == head || prevNode.count < currentCount - 1) {
                prevNode = new Node(currentCount - 1);
                nodeMap.put(currentCount - 1, prevNode);
                insertNodeAfter(prevNode, currentNode.prev);
            }
            prevNode.keys.add(key);
            removeKeyFromNode(currentCount, key);
        }

        private void removeKeyFromNode(int count, String key) {
            Node node = nodeMap.get(count);
            node.keys.remove(key);
            if (node.keys.isEmpty()) {
                removeNode(node);
                nodeMap.remove(count);
            }
        }

        private void insertNodeAfter(Node newNode, Node prevNode) {
            newNode.prev = prevNode;
            newNode.next = prevNode.next;
            prevNode.next.prev = newNode;
            prevNode.next = newNode;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
