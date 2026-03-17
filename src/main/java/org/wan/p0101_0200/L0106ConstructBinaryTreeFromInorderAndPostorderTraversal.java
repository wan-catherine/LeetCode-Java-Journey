package org.wan.p0101_0200;

import org.wan.util.TreeNode;

import java.util.HashMap;

public class L0106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> imap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            imap.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1, inorder, 0, postorder.length - 1,  postorder, imap);
    }

    private TreeNode helper(int il, int ir, int[] inorder, int pl, int pr, int[] postorder, HashMap<Integer, Integer> imap) {
        if (pl == pr) {
            return new TreeNode(postorder[pl]);
        }

        int idx = imap.get(postorder[pr]);
        int l = idx - il;
        if (idx == il) {
            TreeNode right = helper(idx + 1, ir, inorder, pl + l, pr - 1, postorder, imap);
            return new TreeNode(postorder[pr],  null, right);
        } else if (idx == ir) {
            TreeNode left = helper(il, il + l - 1, inorder, pl, pl + l - 1, postorder, imap);
            return new TreeNode(postorder[pr],  left, null);
        } else {
            TreeNode left = helper(il, il + l - 1, inorder, pl, pl + l - 1, postorder, imap);
            TreeNode right = helper(idx + 1, ir, inorder, pl + l, pr - 1, postorder, imap);
            return new TreeNode(postorder[pr],  left, right);
        }
    }
}
