import java.util.Scanner;
import java.util.Stack;

class Main {
	static int n, m;
	static boolean[] visit;
	static Stack<Integer> stack;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[n + 1];
		stack = new Stack<Integer>();
		dfs(0);
	}

	static void dfs(int dep) {
		if (dep == m) {
			for (int i = 0; i < m; i++)
				System.out.print(stack.get(i) + " ");
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				stack.push(i);
				dfs(dep + 1);
				stack.pop();
				visit[i] = false;
			}
		}
	}
}
