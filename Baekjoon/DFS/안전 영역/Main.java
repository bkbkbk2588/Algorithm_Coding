import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(), max = -1, answer = 0;
		int[][] arr = new int[size][size];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
				if (max < arr[i][j])
					max = arr[i][j];
			}
		}

		for (int i = max - 1; i >= 0; i--)
			answer = Math.max(deluge(arr, i), answer);

		System.out.println(answer);
	}

	static int deluge(int[][] arr, int water) {
		int[][] tempArr = new int[arr.length][arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++)
				tempArr[i][j] = arr[i][j];
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (water >= tempArr[i][j])
					tempArr[i][j] = 0;
			}
		}
		return count(tempArr);
	}

	static int count(int[][] arr) {
		boolean[][] visit = new boolean[arr.length][arr.length];
		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0 && !visit[i][j]) {
					dfs(arr, visit, i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void dfs(int[][] arr, boolean[][] visit, int x, int y) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { x, y });
		visit[x][y] = true;

		while (!stack.isEmpty()) {
			int[] temp = stack.peek();
			boolean flag = false;

			for (int i = 0; i < 4; i++) {
				int xpos = temp[0] + dx[i], ypos = temp[1] + dy[i];

				if (xpos < 0 || ypos < 0 || xpos >= arr.length || ypos >= arr.length)
					continue;

				if (arr[xpos][ypos] != 0 && !visit[xpos][ypos]) {
					visit[xpos][ypos] = true;
					stack.push(new int[] { xpos, ypos });
					flag = true;
				}
			}
			if (!flag)
				stack.pop();
		}
	}
}
