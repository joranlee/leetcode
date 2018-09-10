package hashtable.q811;

public class TestSpilt {
	public static void main(String[] args) {
		String tests = "901 domain.cnpc";
		String[] tArray = tests.split(" ");
		for(String s: tArray) {
			System.out.println(s);
		}
	}
}
