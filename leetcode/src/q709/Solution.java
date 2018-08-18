package q709;
/*
 * 2018-08-05
 * To Lower Case    
 */
public class Solution {

	public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for(int i = 0 ; i < a.length ; i ++){
            if(a[i] >= 'A' && a[i] <= 'Z'){
                a[i] = (char)(a[i] - 'A' + 'a');
            }
        }
        return new String(a);
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.toLowerCase("ShekRkde"));
	}
}
