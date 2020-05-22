import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int n, int[][] edge) {
		int answer = 0, max = 0;
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[n + 1];
		int[] value = new int[n + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		visit[0] = true;
		visit[1] = true;
		queue.add(1);

		value[1] = 1;

		for (int i = 0; i < edge.length; i++)
			list.add(new ArrayList<Integer>());

		for (int[] node : edge) {
			int num1 = node[0], num2 = node[1];
			list.get(num1).add(num2);
			list.get(num2).add(num1);
		}

		while (!queue.isEmpty()) {
			int index = queue.poll();

			for (int i : list.get(index)) {
				if (!visit[i]) {
					queue.add(i);
					visit[i] = true;
					value[i] = value[index] + 1;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (max < value[i])
				max = value[i];
		}
		for (int i = 1; i <= n; i++) {
			if (value[i] == max)
				answer++;
		}
		return answer;
	}
}