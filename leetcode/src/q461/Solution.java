package q461;

/**
 * @author TXX 2018-08-19 
 * 思路：将x,y两个数做异或，若某一位不同，则异或之后该位为1。下一步统计异或之后结果是1的位数即可。
 * 思路更新：Integer.bitCount方法可以直接获取二进制表示中1的个数
 */
public class Solution {
	public int hammingDistance(int x, int y) {
		int xor = x ^ y;
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = result + ((xor >> i)&1);
		}
		return result;
	}
	
	public int hammingDistance2(int x, int y) {
		int xor = x ^ y;
		int result = 0;
		result = Integer.bitCount(xor);
		return result;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.hammingDistance(1, 4));
		System.out.println(s.hammingDistance2(1, 4));
	}
}
