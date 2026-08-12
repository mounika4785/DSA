/* Structure of Doubly Linked List Node
class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}; */

class Solution {
    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Node p1 = head;
        Node p2 = head;

        while (p2.next != null) {
            p2 = p2.next;
        }

        while (p1 != null && p2 != null && p1 != p2 && p1.prev != p2) {
            int sum = p1.data + p2.data;

            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(p1.data);
                pair.add(p2.data);
                list.add(pair);

                p1 = p1.next;
                p2 = p2.prev;
            }
            else if (sum > target) {
                p2 = p2.prev;
            }
            else {
                p1 = p1.next;
            }
        }

        return list;
    }
}