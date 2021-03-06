package com.algo.progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.algo.easy.TreeNode;

/**
 * 112. Path Sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<>();
		return postOrder(root, stack, sum);
	}

	boolean postOrder(TreeNode node, Stack<TreeNode> stack, int sum) {
		boolean flag = false;
		if(node != null) {
			stack.push(node.left);
			stack.push(node.right);
			if(node.left == null && node.right == null) {
				List<TreeNode> list = new ArrayList<>(stack);
				if(list.stream().mapToInt(e -> e.val).sum() == sum) {
					flag = true;
				}
				stack.pop();
			}
		}
		return flag;
	}
}
