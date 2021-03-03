package com.algo.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 653. Two Sum IV - Input is a BST
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class TwoSum653 {

	public boolean findTarget(TreeNode root, int k) {
		List<Integer> sorted = new ArrayList<>();
		inorder(root, sorted);
		int left = 0;
		int right = sorted.size() - 1;
		while(left < right) {
			int cal = sorted.get(left) + sorted.get(right);
			if(cal == k) {
				return true;
			} else if(cal < k) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	public void inorder(TreeNode node, List<Integer> list) {
		if(node != null) {
			inorder(node.left, list);
			list.add(node.val);
			inorder(node.right, list);
		}
	}
}
