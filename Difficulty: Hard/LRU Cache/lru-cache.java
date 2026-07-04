import java.util.HashMap;

class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static int capacity;
    static HashMap<Integer, Node> map = new HashMap<>();
    static Node head;
    static Node tail;

    LRUCache(int cap) {
        capacity = cap;
        map.clear();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    static void addNode(Node node) {
        Node temp = head.next;

        node.next = temp;
        node.prev = head;

        head.next = node;
        temp.prev = node;
    }

    static void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public static int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        deleteNode(node);
        addNode(node);

        return node.value;
    }

    public static void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            map.remove(key);
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            deleteNode(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}