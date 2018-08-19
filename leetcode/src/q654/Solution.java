package q654;

/**
 * @author TXX 2018-08-19
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return genTree(nums, 0, nums.length - 1);
	}

	private TreeNode genTree(int[] nums, int start, int end) {
		if (start > end)
			return null;
		// 获取最大的数
		int max = start;
		for (int i = start + 1; i <= end; i++) {
			if (nums[i] > nums[max]) {
				max = i;
			}
		}

		TreeNode root = new TreeNode(nums[max]);
		root.left = genTree(nums, start, max - 1);
		root.right = genTree(nums, max + 1, end);

		return root;
	}
}
