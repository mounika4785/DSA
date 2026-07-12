/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isBalanced(Node root) {
        return height(root) != -1;
    }

    int height(Node root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        if (left == -1)
            return -1;

        int right = height(root.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
}
        