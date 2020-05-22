import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public static int solution(String arrangement) {
		int answer = 0, stick = 0;
		String[] temp = arrangement.split("");
		Queue<String> queue = new LinkedList<String>();

		for (String i : temp) {
			queue.offer(i);
		}

		while (!queue.isEmpty()) {
			if (queue.peek().equals("(")) {
				stick++;
				queue.poll();
				if(queue.peek().equals(")")) {
					stick--;
					queue.poll();
					answer+=stick;
				}
			} else if(queue.peek().equals(")")) {
				queue.poll();
				stick--;
				answer++;
			}
		}
		return answer;
	}
}
