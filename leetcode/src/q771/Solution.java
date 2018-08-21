package q771;
/*
 * 2018-08-05  通过率81.9%
 * Jewels and Stones    
 */
public class Solution {
	 public int numJewelsInStones(String J, String S) {
	        int result = 0;
	        char[] Jchar = J.toCharArray();
	        char[] Schar = S.toCharArray();
	        
	        for(char b : Schar) {
	        	for(char j : Jchar) {
	        		if(j == b) {
	        			result++;
	        		}
	        	}
	        }
	                
	        return result; 
	    }
	 
	 public static void main(String[] args) {
		String J = "aWQ";
		String S = "ejsoWWiAaWwQq";
		Solution ssSolution = new Solution();
		System.out.println(ssSolution.numJewelsInStones(J, S));
	}
}
