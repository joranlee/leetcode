package q804;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author TXX 2018-08-18
 *         思路：用map来存储字母和morse之间的映射，通过map.get获取字母转换morse的结果。将morse转换结果存储到一个set中，因为set中的元素不重复，故最后set中的元素数即是所需结果
 * 		       思路更新：用map来存储字母和morse之间的映射不是必要的，直接用每个word的每个字母-'a'作为索引去morseCode数组中寻找对应morse结果即可
 */
public class Solution {
	public int uniqueMorseRepresentations(String[] words) {
		char key = 'a';
		// 声明字母，morse数组
		final String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
				"--.." };
		final String[] letter = new String[26];
		for (int i = 0; i < 26; i++) {
			letter[i] = String.valueOf(key++);
		}

		// 构造字母和morse之间的映射map
		Map<String, String> morseMap = new HashMap<String, String>();
		for (int i = 0; i < 26; i++) {
			morseMap.put(letter[i], morseCode[i]);
		}

		// 用来保存结果的set
		Set<String> resultSet = new HashSet<String>();
		// 将每一个word转换为对应的morse，并将morse结果存储到set中
		for (String s : words) {
			StringBuffer sb = new StringBuffer();
			char[] word = s.toCharArray();
			for (char c : word) {
				sb.append(morseMap.get(String.valueOf(c)));
			}
			String letterMorse = sb.toString();
			resultSet.add(letterMorse);
		}

		return resultSet.size();
	}

	public int uniqueMorseRepresentations2(String[] words) {
		final String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
				".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
				"--.." };

		// 用来保存结果的set
		Set<String> resultSet = new HashSet<String>();
		// 将每一个word转换为对应的morse，并将morse结果存储到set中
		for (String s : words) {
			StringBuffer sb = new StringBuffer();
			char[] word = s.toCharArray();
			for (char c : word) {
				sb.append(morseCode[c - 'a']);
			}
			resultSet.add(sb.toString());
		}

		return resultSet.size();
	}

	public static void main(String[] args) {
		String[] words = { "gin", "zen", "gig", "msg" };
		Solution s = new Solution();
		int result = s.uniqueMorseRepresentations(words);
		System.out.println(result);
		System.out.println(s.uniqueMorseRepresentations2(words));
	}
}
