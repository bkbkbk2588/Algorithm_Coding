import java.util.Scanner;

class Main {
	static int[] arr, cal;
	static int answer = 0;
	static boolean[] visit;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		arr = new int[num];
		cal = new int[num];
		visit = new boolean[num];

		for (int i = 0; i < num; i++)
			arr[i] = sc.nextInt();

		dfs(0);
		System.out.println(answer);

	}

	static void dfs(int dep) {
		int sum = 0;
		if (arr.length == dep) {
			for (int i = 0; i < cal.length - 1; i++)
				sum += Math.abs(cal[i] - cal[i + 1]);
			answer = Math.max(sum, answer);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				cal[dep] = arr[i];
				dfs(dep + 1);
				visit[i] = false;
			}
		}
	}
}
