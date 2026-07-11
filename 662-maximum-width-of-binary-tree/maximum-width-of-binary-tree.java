/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    TreeNode node;
    long index;

    Pair(TreeNode node, long index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            long minIndex = q.peek().index; // first index of current level

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair current = q.poll();
                long curIndex = current.index - minIndex;

                if (i == 0)
                    first = curIndex;

                if (i == size - 1)
                    last = curIndex;

                if (current.node.left != null) {
                    q.offer(new Pair(current.node.left, 2 * curIndex + 1));
                }

                if (current.node.right != null) {
                    q.offer(new Pair(current.node.right, 2 * curIndex + 2));
                }
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }
}