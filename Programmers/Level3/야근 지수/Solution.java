import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < works.length; i++)
			queue.offer(works[i]);

		for (int i = 0; i < n; i++) {
			int num = queue.poll() - 1;
            
            if (num < 0)
				num = 0;
            
			queue.offer(num);
		}

		int size = queue.size();
		for (int i = 0; i < size; i++)
			answer += Math.pow(queue.poll(), 2);

		return answer;
	}
}