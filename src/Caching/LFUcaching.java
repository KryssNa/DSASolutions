package Caching;

import java.util.HashMap;


public class LFUcaching {

        int capacity;
        HashMap<Integer, Node> map;
        Node head;
        Node tail;

        LFUcaching(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
        }

        public static class Node {
            int key;
            int value;
            int freq;
            Node next;
            Node prev;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = this.prev = null;
                this.freq = 1;
            }
        }

        void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                node.freq++;
                updateNode(node);
            } else {
                if (map.size() == capacity) {
                    removeLFUNode();
                }
                Node newnode = new Node(key, value);
                map.put(key, newnode);
                insert(newnode);
            }
        }

        int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            node.freq++;
            updateNode(node);
            return node.value;
        }

        private void insert(Node newnode) {
            if (head == null) {
                head = tail = newnode;
            } else {
                newnode.next = head;
                head.prev = newnode;
                head = newnode;
            }
        }

    private void removeNode(Node node){
            if (node==null){
                return;
            }
        if(node==head){
            head.next.prev=null;
            head=node.next;
            node.next=null;
        }
        else if(node==tail){
            tail.prev.next=null;
            tail=tail.prev;
            node.prev=null;
        }
        else{
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.prev=null;
            node.next=null;
        }
    }

    private void updateNode(Node node) {
            removeNode(node);
            Node curr = head;
            while (curr != null && curr.freq >= node.freq) {
                curr = curr.next;
            }
            if (curr == null) {
                insert(node);
            } else {
                node.next = curr;
                node.prev = curr.prev;
                if (curr.prev != null) {
                    curr.prev.next = node;
                }
                curr.prev = node;
            }
        }

    private void removeLFUNode() {
        if (tail != null) {
            map.remove(tail.key);
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                    tail.next = null;
            }
        }
    }


    public static void main(String[] args) {
            LFUcaching cache = new LFUcaching(2);
            cache.put(1, 1);
            cache.put(2, 2);
            System.out.println(cache.get(1));       // returns 1
            cache.put(3, 3);    // evicts key 2
            System.out.println(cache.get(2));       // returns -1 (not found)
            System.out.println(cache.get(3));       // returns 3.
            cache.put(4, 4);    // evicts key 1.
            System.out.println(cache.get(1));       // returns -1 (not found)
            System.out.println(cache.get(3));       // returns 3
            System.out.println(cache.get(4));       // returns 4
        }

}
