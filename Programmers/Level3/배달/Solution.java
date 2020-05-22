import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		int[] charge = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		int[][] arr = new int[N + 1][N + 1];
		Arrays.fill(charge, Integer.MAX_VALUE);
		charge[1] = 0;
		visit[0] = true;
		visit[1] = true;

		for (int i = 0; i < road.length; i++) {
			int start = road[i][0], end = road[i][1], num = road[i][2];
			if (arr[start][end] > num || arr[start][end] == 0) {
				arr[start][end] = num;
				arr[end][start] = num;
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);

		while (!queue.isEmpty()) {
			int min = Integer.MAX_VALUE, temp = 0, index = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (!visit[i] && (arr[index][i] != 0))
					charge[i] = Math.min(charge[i], charge[index] + arr[index][i]);
			}

			for (int i = 1; i <= N; i++) {
				if (!visit[i] && (charge[i] < min)) {
					min = charge[i];
					temp = i;

				}
			}
			if (temp != 0) {
				visit[temp] = true;
				queue.offer(temp);
			}
		}
		for (int i = 1; i <= N; i++) {
			if (charge[i] <= K)
				answer++;
		}
		return answer;
	}
}