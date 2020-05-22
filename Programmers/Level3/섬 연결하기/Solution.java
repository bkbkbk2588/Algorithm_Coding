import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {
	public boolean check(int[][] arr, int num1, int num2) {
		boolean flag = false;
		boolean[] visit = new boolean[arr.length];
		Stack<Integer> stack = new Stack<>();

		stack.push(num1);
		visit[num1] = true;

		while (!stack.isEmpty()) {
			int index = stack.peek(), temp = 0;
			flag = false;
			for (int i = 0; i < arr[0].length; i++) {
				if (!visit[i] && arr[index][i] == 1) {
					visit[i] = true;
					flag = true;
					stack.push(i);
					break;
				}

				else if (visit[i] && arr[index][i] == 1) {
					if ((stack.size() > 2) && i == num1)
						return false;
				}

			}

			if (!flag)
				stack.pop();
		}
		return true;
	}

	public int solution(int n, int[][] costs) {
		int answer = 0, num=1;
		int[][] arr = new int[n][n];

		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] entry1, int[] entry2) {
				return Integer.compare(entry1[2], entry2[2]);
			}
		});

		for (int i = 0; i < costs.length; i++) {
			int num1 = costs[i][0], num2 = costs[i][1];
			arr[num1][num2] = 1;
			arr[num2][num1] = 1;

			if (check(arr, num1, num2)) {
				num++;
				answer += costs[i][2];
			}
			else {
				arr[num1][num2] = 0;
				arr[num2][num1] = 0;
			}
		}
		return answer;
	}
}