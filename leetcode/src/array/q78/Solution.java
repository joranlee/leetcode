package array.q78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TXX 2018-08-21 Given a set of distinct integers, nums, return all
 *         possible subsets (the power set).
 * 
 *         Note: The solution set must not contain duplicate subsets.
 * 
 *         Example:
 * 
 *         Input: nums = [1,2,3] Output: [ [3], [1], [2], [1,2,3], [1,3],
 *         [2,3],[1,2], [] ]
 * 
 *         给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 *         思路：首先向结果list中添加一个空的list，之后，取数组中的第一个元素，添加到结果list
 *         中的list<int>里，并将这个新的list添加到结果list中。之后，将每一个数组中的元素，依
 *         次添加到已经存在的list<int>中，并将新的list<int>加入到结果list内，直到数组中元素用尽。
 * 
 *         以{1,2,3}为例，初始结果list为[ [] ] 
 *         取1，则结果list为[ [] ， [1] ] 
 *         再取2，则结果list为[ [] ，[1] ， [2] , [1,2] ] 
 *         再取3，则结果list为[ [] ， [1] ， [2] , [1,2] ， [3] ,[1,3] , [2,3] , [1,2,3]]
 */
public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		for (int n : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> list = new ArrayList<>(result.get(i));
				list.add(n);
				result.add(list);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		Solution s = new Solution();
		List<List<Integer>> result = s.subsets(nums);
		for (List l : result) {
			System.out.println(l);
		}
	}
}
