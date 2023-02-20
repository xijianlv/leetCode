package com.xijianlv.leetcode;

import com.xijianlv.leetcode.tool.TreeNode;

import java.util.HashMap;

/**
 * @author xijianlv
 */
public class No334 {
    HashMap<TreeNode, Integer> takeAway = new HashMap<TreeNode, Integer>();
    HashMap<TreeNode, Integer> giveUp = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(takeAway.getOrDefault(root, 0), giveUp.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        takeAway.put(node, node.val + giveUp.getOrDefault(node.right, 0)
                + giveUp.getOrDefault(node.left, 0));
        giveUp.put(node, Math.max(takeAway.getOrDefault(node.left, 0), giveUp.getOrDefault(node.left, 0))
                + Math.max(takeAway.getOrDefault(node.right, 0), giveUp.getOrDefault(node.right, 0)));
    }

}
