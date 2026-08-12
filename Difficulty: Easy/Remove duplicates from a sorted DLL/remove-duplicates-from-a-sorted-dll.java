/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        Node p1 = head;
        p1.prev = null;
        Node p2 = head.next;
        while(p2!= null){
           if(p1.data !=  p2.data){
               p1.next = p2;
               p2.prev = p1;
               p1 = p1.next;
           }
           p2 = p2.next;
        }
        p1.next = null;
       return head;
    }
}