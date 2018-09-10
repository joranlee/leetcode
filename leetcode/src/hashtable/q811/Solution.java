package hashtable.q811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.

Example 1:
Input: 
["9001 discuss.leetcode.com"]
Output: 
["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
Explanation: 
We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.

Example 2:
Input: 
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output: 
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation: 
We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.

Notes:

The length of cpdomains will not exceed 100. 
The length of each domain name will not exceed 100.
Each address will have either 1 or 2 "." characters.
The input count in any count-paired domain will not exceed 10000.
The answer output can be returned in any order.
 */
public class Solution {
	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> domainMap = new HashMap<>();
		for (String s : cpdomains) {

			// 通过空格将cpdomains中的元素拆成个数，域名两部分；
			String[] sArray = s.split(" ");
			// 将个数部分转化为int
			int count = Integer.valueOf(sArray[0]);

			// 将域名部分按'.'分隔
			String[] domains = sArray[1].split("\\.");
			String createDomain = "";
			for (int i = domains.length - 1; i >= 0; i--) {
				// 从最后一个domain开始，拼接domain
				createDomain = (createDomain == "" ? domains[i] : domains[i] + "." + createDomain);
				// 以拼接好的domain为key在map中查询，如果没有此key，则放到map中；如果有此key，将对应的value值更新。
				if (!domainMap.containsKey(createDomain)) {
					domainMap.put(createDomain, count);
				} else {
					domainMap.put(createDomain, count + domainMap.get(createDomain));
				}
			}
		}

		List<String> result = new ArrayList<>();
		for (String s : domainMap.keySet()) {
			result.add(domainMap.get(s) + " " + s);
		}
		return result;
	}

	public static void main(String[] args) {
		String[] inputString = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
		Solution s = new Solution();
		List<String> result = s.subdomainVisits(inputString);
		for (String v : result) {
			System.out.println(v);
		}
	}
}
