package array.q485;

/**
 * @author TXX 2018-09-04 Given a binary array, find the maximum number of
 *         consecutive 1s in this array.
 * 
 *         Example 1: Input: [1,1,0,1,1,1] Output: 3 Explanation: The first two
 *         digits or the last three digits are consecutive 1s. The maximum
 *         number of consecutive 1s is 3. Note:
 * 
 *         The input array will only contain 0 and 1. The length of input array
 *         is a positive integer and will not exceed 10,000
 *         
 *         求一个0,1数组中最大连续1的长度。
 *         思路：两个计数器A，B。A记录当前连续1的长度，B记录当前最大的连续1的长度。
 *         当前是1时，将A加一，判断A是否大于B，若大于，则将B置为A。当前是0时，将A归零。
 *         
 *         思路更新：将A，B大小的判断放在当前是0的时候。这样，如果碰见连续的1，只要自增A即可，无需每次都判断是否比B大。
 */
public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int tempMax = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				tempMax++;

			} else {
				if (tempMax > max) {
					max = tempMax;
				}
				tempMax = 0;
			}
		}
		if (tempMax > max) {
			max = tempMax;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1 };
		Solution s = new Solution();
		System.out.println(s.findMaxConsecutiveOnes(nums));
	}
}
