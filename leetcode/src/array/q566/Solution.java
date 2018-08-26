package array.q566;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TXX 2018-08-26In MATLAB, there is a very useful function called
 *         'reshape', which can reshape a matrix into a new one with different
 *         size but keep its original data.
 * 
 *         You're given a matrix represented by a two-dimensional array, and two
 *         positive integers r and c representing the row number and column
 *         number of the wanted reshaped matrix, respectively.
 * 
 *         The reshaped matrix need to be filled with all the elements of the
 *         original matrix in the same row-traversing order as they were.
 * 
 *         If the 'reshape' operation with given parameters is possible and
 *         legal, output the new reshaped matrix; Otherwise, output the original
 *         matrix.
 * 
 *         Example 1: Input: nums = [[1,2], [3,4]] r = 1, c = 4 Output:
 *         [[1,2,3,4]] Explanation: The row-traversing of nums is [1,2,3,4]. The
 *         new reshaped matrix is a 1 * 4 matrix, fill it row by row by using
 *         the previous list. Example 2: Input: nums = [[1,2], [3,4]] r = 2, c =
 *         4 Output: [[1,2], [3,4]] Explanation: There is no way to reshape a 2
 *         * 2 matrix to a 2 * 4 matrix. So output the original matrix. Note:
 *         The height and width of the given matrix is in range [1, 100]. The
 *         given r and c are all positive.
 * 
 *         思路：将原矩阵元素存储到一个list中，再依次向新的矩阵中写入list中的元素。 
 *         思路2： 两个矩阵中对应元素下角标的乘积是有对应关系的
 * 
 */
public class Solution {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int rowNum = nums.length;
		int colNum = nums[0].length;
		if (rowNum * colNum != r * c) {
			return nums;
		}

		int[][] result = new int[r][c];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				list.add(nums[i][j]);
			}
		}
		int index = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = list.get(index++);
			}
		}

		return result;
	}

	public int[][] matrixReshape2(int[][] nums, int r, int c) {
		int rowNum = nums.length;
		int colNum = nums[0].length;
		if (rowNum * colNum != r * c) {
			return nums;
		}

		int[][] result = new int[r][c];
		int index = 0;
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				result[index / c][index % c] = nums[i][j];
				index++;
			}
		}

		return result;
	}


	public static void main(String[] args) {
		int[][] nums = { { 1, 2 }, { 3, 4 } };
		Solution s = new Solution();
		int[][] result = s.matrixReshape(nums, 1, 4);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		int[][] result2 = s.matrixReshape2(nums, 1, 4);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result2[i][j] + " ");
			}
			System.out.println();
		}
	}
}
