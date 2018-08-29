package array.q888;

/**
 * @author TXX 2018-08-29 Alice and Bob have candy bars of different sizes: A[i]
 *         is the size of the i-th bar of candy that Alice has, and B[j] is the
 *         size of the j-th bar of candy that Bob has.
 * 
 *         Since they are friends, they would like to exchange one candy bar
 *         each so that after the exchange, they both have the same total amount
 *         of candy. (The total amount of candy a person has is the sum of the
 *         sizes of candy bars they have.)
 * 
 *         Return an integer array ans where ans[0] is the size of the candy bar
 *         that Alice must exchange, and ans[1] is the size of the candy bar
 *         that Bob must exchange.
 * 
 *         If there are multiple answers, you may return any one of them. It is
 *         guaranteed an answer exists.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: A = [1,1], B = [2,2] Output: [1,2] Example 2:
 * 
 *         Input: A = [1,2], B = [2,3] Output: [1,2] Example 3:
 * 
 *         Input: A = [2], B = [1,3] Output: [2,3] Example 4:
 * 
 *         Input: A = [1,2,5], B = [2,4] Output: [5,4]
 * 
 *         两个数组互相交换且仅互相交换一对值，使得交换之后两个数组的和相同。 思路：双重循环，若sumA - A[i] + B[j] = sumB
 *         - B[j] + A[i],则A[i],B[j]就是一组值。时间复杂度为n^2 sumA - A[i] + B[j] = sumB -
 *         B[j] + A[i] 经变换后，得到A[i] - B[j] = (sumA - sumB)/2
 *         可以先算出这个值，减少每个循环中的计算次数。
 */
public class Solution {
	public int[] fairCandySwap(int[] A, int[] B) {
		int[] ans = new int[2];
		int sumA = 0, sumB = 0;

		for (int i : A) {
			sumA += i;
		}
		for (int i : B) {
			sumB += i;
		}

		int c = (sumA - sumB) / 2;

		for (int i = 0; i < A.length; i++) {
			int num = A[i] - c;
			for (int j = 0; j < B.length; j++) {
				if (B[j] == num) {
					ans[0] = A[i];
					ans[1] = B[j];
					return ans;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 5 };
		int[] B = { 2, 4 };
		Solution s = new Solution();
		int[] ans = s.fairCandySwap(A, B);
		for(int i : ans) {
			System.out.println(i);
		}
	}
}
