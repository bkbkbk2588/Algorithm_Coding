import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[] A, int[] B) {
		int answer = 0, size = A.length;
		PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < size; i++) {
			a.add(A[i]);
			b.add(B[i]);
		}
		
		for (int i = 0; i < size; i++) {
			if(a.peek()<b.peek()) {
				a.poll();
				b.poll();
				answer++;
			}
			else
				a.poll();
		}
		return answer;
	}
}