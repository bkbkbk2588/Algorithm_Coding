import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		for (int tc = 0; tc < test; tc++) {
			int column = sc.nextInt(), row = sc.nextInt(), spot = sc.nextInt();
			int[][] arr = new int[row + 2][column + 2];
			boolean[][] visit = new boolean[row + 2][column + 2];
			Stack<Integer> stackX = new Stack<>();
			Stack<Integer> stackY = new Stack<>();

			int answer = 0;

			for (int i = 0; i < spot; i++) {
				int y = sc.nextInt(), x = sc.nextInt();
				if (i == 0) {
					stackX.push(x + 1);
					stackY.push(y + 1);
					visit[x + 1][y + 1] = true;
				}

				arr[x + 1][y + 1] = 1;
			}

			while (!stackX.isEmpty()) {
				int tempX = stackX.peek(), tempY = stackY.peek();

				if (arr[tempX - 1][tempY] == 1 && !visit[tempX - 1][tempY]) {
					stackX.push(tempX - 1);
					stackY.push(tempY);
					visit[tempX - 1][tempY] = true;
					continue;
				}
				if (arr[tempX][tempY + 1] == 1 && !visit[tempX][tempY + 1]) {
					stackX.push(tempX);
					stackY.push(tempY + 1);
					visit[tempX][tempY + 1] = true;
					continue;
				}

				if (arr[tempX + 1][tempY] == 1 && !visit[tempX + 1][tempY]) {
					stackX.push(tempX + 1);
					stackY.push(tempY);
					visit[tempX + 1][tempY] = true;
					continue;
				}

				if (arr[tempX][tempY - 1] == 1 && !visit[tempX][tempY - 1]) {
					stackX.push(tempX);
					stackY.push(tempY - 1);
					visit[tempX][tempY - 1] = true;
					continue;
				}

				stackX.pop();
				stackY.pop();

				if (stackX.isEmpty()) {
					boolean flag = false;
					answer++;
					for (int i = 1; i < arr.length - 1; i++) {
						for (int j = 1; j < arr[i].length - 1; j++) {
							if (arr[i][j] == 1 & !visit[i][j]) {
								stackX.push(i);
								stackY.push(j);
								visit[i][j] = true;
								flag = true;
								break;
							}
						}
						if (flag)
							break;
					}
				}
			}
			System.out.println(answer);
		}
	}
}
