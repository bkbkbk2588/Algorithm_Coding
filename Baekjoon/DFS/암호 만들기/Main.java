import java.util.Arrays;
import java.util.Scanner;

class Main {
	static boolean[] visit;
	static String[] arr;
	static int size, ja, mo;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		int cnt = sc.nextInt();
		sc.nextLine();
		String temp = sc.nextLine();
		arr = temp.split(" ");
		visit = new boolean[cnt];
		ja = 0;
		mo = 0;

		Arrays.sort(arr);
		dfs(0, 0);

	}

	static void dfs(int dep, int num) {
		boolean flag;
		if ((dep == size) && mo >= 1 && ja >= 2) {
			for (int i = 0; i < visit.length; i++) {
				if (visit[i])
					System.out.print(arr[i]);
			}
			System.out.println();
		}

		for (int i = num; i < arr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;

				if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o")
						|| arr[i].equals("u")) {
					mo++;
					flag = false;
				} else {
					ja++;
					flag = true;
				}

				dfs(dep + 1, i + 1);
				if (flag)
					ja--;
				else
					mo--;
				visit[i] = false;
			}
		}
	}
}
