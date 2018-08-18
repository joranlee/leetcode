package q807;
/*
 * 2018-08-18
 * 思路：寻找二维数组中每个元素所在的行数组和列数组中的最大值，并将该元素设为这两个最大值中较小的那一个。
 *      默认行列数相等,即n*n，如果是m*n，则grid.length获取行数，grid[0].length获取列数。
 */

public class Solution {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		//用来记录结果
		int result = 0;
		int n = grid.length;
		//分别用两个一维数组记录每一行和列的最大值
		int rowMax[] = new int[n]; 
		int columnMax[] = new int [n];
		
		//寻找每一行和每一列的最大值，并记录下来
		for(int r = 0 ; r < n ; r ++) {
			for(int c = 0 ; c < n ; c ++) {
				rowMax[r] = Math.max(rowMax[r], grid[r][c]);
				columnMax[c] = Math.max(columnMax[c] , grid[r][c]);
			}
		}
		for(int i : rowMax) 
			System.out.print(i + " ");
		for(int i : columnMax) 
			System.out.print(i + " ");
		
		//用元素所在行列两个最大值中较小的那一个减去元素原值，即是能够增加的部分
		for(int r = 0 ; r < n ; r ++) {
			for(int c = 0 ; c < n ; c ++) {
				result += (Math.min(rowMax[r], columnMax[c]) - grid[r][c]);
			}
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1,4,6,3},{2,3,5,8},{6,4,9,7},{3,2,8,7}};
		Solution s = new Solution();
		s.maxIncreaseKeepingSkyline(grid);
	}
}
