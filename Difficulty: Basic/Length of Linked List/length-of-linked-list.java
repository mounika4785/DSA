/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int a){
        data = a;
        next = null;
    }
}
*/
class Solution {
    public int getCount(Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length += 1;
            temp = temp.next;
        }
        return length;
    }
}
        