import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 1, bridge_weight = 0, peek_number = 0;
		Queue<Integer> now = new LinkedList<Integer>();
		Queue<Integer> go = new LinkedList<Integer>();
		Queue<Integer> finish = new LinkedList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer temp = 0;

		for (int i = 0; i < truck_weights.length; i++)
			now.offer(truck_weights[i]);

		while (finish.size() != truck_weights.length){
			if (!now.isEmpty()) {
				peek_number = now.peek();

				if (bridge_weight + peek_number <= weight) {
					bridge_weight += peek_number;
					go.offer(now.poll());
					list.add(0);
				}
			}

			for (int i = 0; i < list.size(); i++) {
				temp = list.get(i) + 1;
				list.set(i, temp);
			}
			
			if (list.get(0).equals(bridge_length)) {
				bridge_weight -= go.poll();
				list.remove(0);
				finish.offer(1);
			}
			answer++;
		}
		return answer;
	}
}
