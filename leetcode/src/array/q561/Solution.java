package array.q561;

import java.util.Arrays;

/**
 * @author TXX 2018-08-20 Given an array of 2n integers, your task is to group
 *         these integers into n pairs of integer, say (a1, b1), (a2, b2), ...,
 *         (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as
 *         large as possible.
 * 
 *         Example 1: Input: [1,4,3,2]
 * 
 *         Output: 4 Explanation: n is 2, and the maximum sum of pairs is 4 =
 *         min(1, 2) + min(3, 4).
 * 
 *         Note: n is a positive integer, which is in the range of [1, 10000].
 *         All the integers in the array will be in the range of [-10000,
 *         10000].
 * 
 *         给定一个包含2n个数的数组，将他们两两分成n组，目标是使n个组最小值的和最大。
 *         思路：冒泡排序后隔一取一？可能能成功，但是时间复杂度会到n2，也许会超时。事后证明提交时报了TLE错误。
 *         思路更新：隔一取一思路是正确的，排序时直接利用的Arrays.sort()方法。快速排序算法，时间复杂度n*logn。
 * 
 *         假设每一组中 均有bi >= ai
 *         令Sm = min(a1,b1) + min(a2,b2) + ... + min(an + bn) 
 *         则Sm = a1 + a2 + ... + an
 *         令Sa = a1 + b1 + a2 + b2 + ... + an + bn
 *         令di = |ai - bi|,因为bi >= ai ,故di = bi - ai
 *         令Sd = d1 + d2 + ... + dn
 *         则Sa = a1 + a1 + d1 + a2 + a2 + d2 + ... + an + an + dn = 2Sm + Sd 
 *         故Sm = (Sa - Sd)/2
 *         因Sa是固定的，若想让Sm最大，则Sd应取最小。当ai，bi相邻时，di可取到最小，也就是让Sd最小。
 *         
 */
public class Solution {
	public int arrayPairSum(int[] nums) {
		int result = 0;
		int[] sorted = bubbleSort(nums);
		for (int i = 0; i < sorted.length; i += 2) {
			result += sorted[i];
		}
		return result;
	}

	public int[] bubbleSort(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}

		return nums;
	}

	public int arrayPairSum2(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 5, 3, 7, 6 };
		Solution s = new Solution();
		int result = s.arrayPairSum(nums);
		int result2 = s.arrayPairSum2(nums);
		System.out.println(result);
		System.out.println(result2);
	}
}
