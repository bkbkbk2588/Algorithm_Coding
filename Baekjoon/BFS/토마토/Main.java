import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(), y = sc.nextInt(), answer = 0, cnt = 0;
		int[][] arr = new int[y][x];
		boolean[][] visit = new boolean[y][x];
		Stack<Integer> stackx = new Stack<Integer>();
		Stack<Integer> stacky = new Stack<Integer>();
		Stack<Integer> xpos = new Stack<Integer>();
		Stack<Integer> ypos = new Stack<Integer>();

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					stackx.push(i);
					stacky.push(j);
					visit[i][j] = true;
					cnt++;
				} else if (arr[i][j] == -1)
					cnt++;
			}
		}

		while (!stackx.isEmpty()) {
			int index_x = stackx.peek(), index_y = stacky.peek();
			boolean flag = false;

			if (index_x - 1 >= 0 && arr[index_x - 1][index_y] != -1 && !visit[index_x - 1][index_y]) {
				visit[index_x - 1][index_y] = true;
				flag = true;
				cnt++;
				xpos.push(index_x - 1);
				ypos.push(index_y);
			}
			if (index_x + 1 < y && arr[index_x + 1][index_y] != -1 && !visit[index_x + 1][index_y]) {
				visit[index_x + 1][index_y] = true;
				flag = true;
				cnt++;
				xpos.push(index_x + 1);
				ypos.push(index_y);
			}
			if (index_y - 1 >= 0 && arr[index_x][index_y - 1] != -1 && !visit[index_x][index_y - 1]) {
				visit[index_x][index_y - 1] = true;
				flag = true;
				cnt++;
				xpos.push(index_x);
				ypos.push(index_y - 1);
			}
			if (index_y + 1 < x && arr[index_x][index_y + 1] != -1 && !visit[index_x][index_y + 1]) {
				visit[index_x][index_y + 1] = true;
				flag = true;
				cnt++;
				xpos.push(index_x);
				ypos.push(index_y + 1);
			}

			if (!flag) {
				stackx.pop();
				stacky.pop();

				if (stackx.isEmpty()) {
					if (!xpos.isEmpty())
						answer++;
					while (!xpos.isEmpty()) {
						stackx.push(xpos.pop());
						stacky.push(ypos.pop());
					}
				}
			}
		}
		if (cnt == (x * y))
			System.out.println(answer);
		else
			System.out.println(-1);
	}
}