/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int height(Node node) {

        if (node == null)
            return -1;

        return 1 + Math.max(height(node.left), height(node.right));
    }
}     