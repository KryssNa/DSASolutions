package LinkedList;


public class LRUcachingUsinglinkedList {
    static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity, count;
    Node head, tail;

    public LRUcachingUsinglinkedList(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = getNode(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            update(node);
        } else {
            node = new Node(key, value);
            add(node);
            if (++count > capacity) {
                Node toRemove = tail.prev;
                remove(toRemove);
                count--;
            }
        }
    }

    private Node getNode(int key) {
        Node current = head.next;
        while (current != tail) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private void add(Node node) {
        Node first = head.next;
        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
    }

    private void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

    private void update(Node node) {
        remove(node);
        add(node);
    }

    public static void main(String[] args) {
        LRUcachingUsinglinkedList lru = new LRUcachingUsinglinkedList(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}
