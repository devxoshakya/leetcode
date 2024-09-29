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
     public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
            (level(root,xx,0) == level(root,yy,0)) && (!isSibling(root,xx,yy))
        );
    }

    private TreeNode findNode(TreeNode root, int x){
        if(root == null){
            return null;
        }
        if(root.val == x){
            return root;
        }
        TreeNode left = findNode(root.left, x);
        if(left != null){
            return left;
        }
        return findNode(root.right, x);
    }

    private boolean isSibling(TreeNode root, TreeNode a, TreeNode b){
        if(root == null){
            return false;
        }
        return (
            ((root.left == a && root.right == b) || (root.left == b && root.right == a)) || isSibling(root.left, a, b) || isSibling(root.right, a, b)
        );
    }

    private int level(TreeNode root, TreeNode x, int lev){
        if(root == null){
            return 0;
        }
        if(root == x){
            return lev;
        }
        int l = level(root.left, x, lev+1);
        if(l != 0){
            return l;
        }
        return level(root.right, x, lev+1);
    }

}