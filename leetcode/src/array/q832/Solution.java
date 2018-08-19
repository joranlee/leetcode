package array.q832;

public class Solution {
	public int[][] flipAndInvertImage(int[][] A) {
		int N = A.length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N / 2; j++) {
				int temp = A[i][j];
				A[i][j] = 1 - A[i][N - 1 - j];
				A[i][N - 1 - j] = 1 - temp;
			}
			if (N % 2 == 1) {
				A[i][N / 2] = 1 - A[i][N / 2];
			}
		}

		return A;
	}

	public static void main(String[] args) {
		int A[][] = { { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 1, 1 } };
		int C[][] = {{1,1,0},{1,0,1},{0,0,0}};
		Solution s = new Solution();
		int B[][] = s.flipAndInvertImage(A);
		int D[][] = s.flipAndInvertImage(C);
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B.length; j++) {
				System.out.print(B[i][j]);
			}
			System.out.println();
		}
		
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				System.out.print(D[i][j]);
			}
			System.out.println();
		}
	}
}
