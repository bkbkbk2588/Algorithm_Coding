import java.util.Arrays;

class Solution {
	public int solution(int[] A, int[] B) {
		int answer = 0, temp = 0;
		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < A.length; i++) {
			temp = A[i] * B[A.length - 1 - i];
			answer+=temp;
		}
		return answer;
	}
}