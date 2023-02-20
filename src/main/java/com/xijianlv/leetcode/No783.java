package com.xijianlv.leetcode;

import com.xijianlv.leetcode.tool.TreeNode;

import java.util.PriorityQueue;

/**
 * @author xijianlv
 */
public class No783 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(71);
        root.right = new TreeNode(84);
        root.left = new TreeNode(62);
        root.left.left = new TreeNode(14);
        root.right.right = new TreeNode(88);
        No783 p = new No783();
        System.out.println(p.minDiffInBST(root));
    }

    public PriorityQueue<Integer> queue = new PriorityQueue<>();

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        int min = Integer.MAX_VALUE;
        int min1 = queue.poll();
        int min2 = queue.poll();
        while (queue != null && queue.size() > 0) {
            if (min2 - min1 < min) {
                min = min2 - min1;
            }
            min1 = min2;
            min2 = queue.poll();
        }
        if (min2 - min1 < min) {
            min = min2 - min1;
        }
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        queue.add(root.val);
    }


}
