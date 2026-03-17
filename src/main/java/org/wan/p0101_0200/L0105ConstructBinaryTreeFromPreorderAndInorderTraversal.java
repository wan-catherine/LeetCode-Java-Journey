package org.wan.p0101_0200;

import org.wan.util.TreeNode;

import java.util.HashMap;

public class L0105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> imap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            imap.put(inorder[i], i);
        }
        return helper(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder, imap);
    }

    private TreeNode helper(int pl, int pr, int il, int ir, int[] preorder, int[] inorder, HashMap<Integer, Integer> imap) {
        if (pl == pr) {
            return new TreeNode(preorder[pl]);
        }
        int idx = imap.get(preorder[pl]);
        int l = idx - il;
        if (idx == il) {
            TreeNode right = helper(pl + l + 1, pr, idx + 1, ir, preorder, inorder, imap);
            return new TreeNode(preorder[pl], null, right);
        } else if (idx == ir) {
            TreeNode left = helper(pl + 1, pl + l, il, idx - 1, preorder, inorder, imap);
            return new TreeNode(preorder[pl], left, null);
        } else {
            TreeNode left = helper(pl + 1, pl + l, il, idx - 1, preorder, inorder, imap);
            TreeNode right = helper(pl + l + 1, pr, idx + 1, ir, preorder, inorder, imap);
            return new TreeNode(preorder[pl], left, right);
        }
    }
}
