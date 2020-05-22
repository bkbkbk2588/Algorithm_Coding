import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		boolean[][] visit = new boolean[n][n];
		Stack<Node> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((arr[i][j] == 1) && !visit[i][j]) {
					stack.push(new Node(i, j));
					list.add(1);
					visit[i][j] = true;
					while (!stack.isEmpty()) {
						Node node = stack.pop();
						int x = node.getX(), y = node.getY();

						if ((y - 1 >= 0) && (arr[x][y - 1] == 1) && (!visit[x][y - 1])) {
							int num = list.get(list.size() - 1);
							stack.push(new Node(x, y - 1));
							visit[x][y - 1] = true;
							list.set(list.size() - 1, num + 1);
						}

						if ((x + 1 < n) && (arr[x + 1][y] == 1) && (!visit[x + 1][y])) {
							int num = list.get(list.size() - 1);
							stack.push(new Node(x + 1, y));
							visit[x + 1][y] = true;
							list.set(list.size() - 1, num + 1);
						}

						if ((y + 1 < n) && (arr[x][y + 1] == 1) && (!visit[x][y + 1])) {
							int num = list.get(list.size() - 1);
							stack.push(new Node(x, y + 1));
							visit[x][y + 1] = true;
							list.set(list.size() - 1, num + 1);
						}

						if ((x - 1 >= 0) && (arr[x - 1][y] == 1) && (!visit[x - 1][y])) {
							int num = list.get(list.size() - 1);
							stack.push(new Node(x - 1, y));
							visit[x - 1][y] = true;
							list.set(list.size() - 1, num + 1);
						}
					}
				}
			}
		}
		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);
		Arrays.sort(answer);
		System.out.println(answer.length);

		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}
}