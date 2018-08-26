package array.q442;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TXX 2018-08-26 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of
 *         array), some elements appear twice and others appear once.
 * 
 *         Find all the elements that appear twice in this array.
 * 
 *         Could you do it without extra space and in O(n) runtime?
 * 
 *         Example: Input: [4,3,2,7,8,2,3,1]
 * 
 *         Output: [2,3]
 * 
 *         数组中的数字为正数，且小于数组长度，每个数字至多出现两次。找出出现了两次的数字。
 *         思路：遍历数组中数字，对于每一个nums[i],将nums[(nums[i])]位置的数字置为其相反数。
 *         之后遍历时，如发现nums[(nums[i])]已经是负数，则证明其已经出现过。
 */
public class Solution {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				result.add(index + 1);
			}
			nums[index] = -nums[index];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 4, 4, 2 };
		Solution s = new Solution();
		List<Integer> res = s.findDuplicates(nums);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
