import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Boolean> temp = new LinkedList<Boolean>();

		for (int i = 0; i < priorities.length; i++) {
			list.add(priorities[i]);
			q.offer(priorities[i]);
			if (i == location)
				temp.offer(true);
			else
				temp.offer(false);
		}

		Collections.sort(list);
		Collections.reverse(list);

		while (true) {
			if (q.peek().equals(list.get(0)) && temp.peek()) {
				answer++;
				break;	
			}
			else if (!temp.peek()) {
				if (q.peek().equals(list.get(0))) {
					q.poll();
					temp.poll();
					list.remove(0);
					answer++;
				} else {
					q.offer(q.poll());
					temp.offer(temp.poll());
				}
			} else if (temp.peek()) {
				q.offer(q.poll());
				temp.offer(temp.poll());
			}
		}
		return answer;
	}
}