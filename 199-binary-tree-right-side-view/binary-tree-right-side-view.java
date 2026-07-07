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
class Solution {
    int maxlevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List <Integer> lst = new ArrayList<>();
        inorder(root, lst,1);
        return lst;
    }
    public void inorder(TreeNode node , List<Integer>lst,int level){
        if(node == null)
          return ;
        if(maxlevel<level){
            lst.add(node.val);
            maxlevel=level;
        }
        inorder(node.right,lst,level+1);
        inorder(node.left,lst,level+1);
        
    }
}