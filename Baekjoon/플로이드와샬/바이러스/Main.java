import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int dfs(int[][] matrix, boolean[] check) {
		int count = 0;
		Stack<Integer> stack = new Stack<Integer>();
		boolean flag;

		stack.push(1);
		check[1] = true;
		int num;

		while (!stack.isEmpty()) {
			flag = false;
			num = stack.peek();
			for (int i = 1; i < matrix.length; i++) {
				if ((matrix[num][i] == 1) && !check[i]) {
					stack.push(i);
					check[i] = true;
					flag = true;
					count++;
				}
			}
			if (!flag)
				stack.pop();
		}

		return count;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int computer = sc.nextInt(), couple = sc.nextInt();
		int[][] matrix = new int[computer + 1][computer + 1];
		boolean[] arrive = new boolean[computer + 1];
		int num1, num2;

		for (int i = 0; i < couple; i++) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			matrix[num1][num2] = 1;
			matrix[num2][num1] = 1;
		}
		int result = dfs(matrix, arrive);

		System.out.println(result);
	}
}