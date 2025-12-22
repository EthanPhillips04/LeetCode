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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        // Search for the node
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node – delete it
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                //  Both children exist
                TreeNode t = succ(root.right); // find inorder successor
                root.val = t.val; // replace value
                root.right = deleteNode(root.right, t.val); // delete successor
            }
        }
        return root;
    }

    // Finds the smallest node in the right subtree
    TreeNode succ(TreeNode n) {
        while (n.left != null) n = n.left;
        return n;
    }
}