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
    private List<Integer> inorder(TreeNode root,List<Integer> nodes) {
        if(root==null) {
            return nodes;
        }
        inorder(root.left,nodes);
        nodes.add(root.val);
        inorder(root.right,nodes);
        return nodes;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes=new ArrayList<>();
        nodes=inorder(root,nodes);
        return nodes.get(k-1);
    }
}
