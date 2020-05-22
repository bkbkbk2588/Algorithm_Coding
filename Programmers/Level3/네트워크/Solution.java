import java.util.Stack;

class Solution {
	boolean[] visit;
	int[][] arr;

	void dfs(int num) {
		boolean flag = false;
		Stack<Integer> stack = new Stack<>();

		stack.push(num);

		while (!stack.isEmpty()) {
			int index = stack.peek();
			flag = false;

			for (int i = 1; i < visit.length; i++) {
				if (arr[index][i] == 1 && !visit[i]) {
					flag = true;
					visit[i] = true;
					stack.push(i);

					break;
				}
			}

			if (!flag)
				stack.pop();
		}
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		arr = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		visit[0] = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i + 1][j + 1] = computers[i][j];
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				dfs(i);
				answer++;
			}
		}
		return answer;
	}
}