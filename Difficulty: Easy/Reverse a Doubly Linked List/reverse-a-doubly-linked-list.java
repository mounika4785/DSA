/* Structure of Doubly Linked List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        Node temp = head;
        Node newHead = null;

        while (temp != null) {
            Node next = temp.next;

            temp.next = temp.prev;
            temp.prev = next;

            newHead = temp;
            temp = next;
        }

        return newHead;
    }
}