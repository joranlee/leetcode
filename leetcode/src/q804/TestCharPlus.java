package q804;

public class TestCharPlus {
	public static void main(String[] args) {
		char c = 'a';
		for (int i = 0; i < 26; i++) {
			System.out.print(c++);
		}
		StringBuffer sb = new StringBuffer();
		System.out.println(sb);
		StringBuffer sb1 = null;
		System.out.println(sb1);
	}
}
