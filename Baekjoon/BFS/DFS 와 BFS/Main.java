import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static int[] dfs(int[][] check, boolean[] bool, int v) {
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();

		stack.push(v);
		arr.add(v);
		bool[v] = true;
		int num, min = 0;
		boolean flag;
		while (!stack.isEmpty()) {
			flag = false;
			num = stack.peek();
			for (int i = 1; i < check.length; i++) {
				if ((check[num][i] == 1) && !bool[i]) {
					min = i;	
					flag = true;
					break;		
				}
			}
			if (flag) {
				stack.push(min);
				arr.add(min);
				bool[min] = true;
			} else
				stack.pop();
		}
		int[] answer = new int[arr.size()];
		int size = 0;
		for (int i : arr)
			answer[size++] = i;

		return answer;
	}

	static int[] bfs(int[][] check, boolean[] bool, int v) {
		Queue<Integer> list = new LinkedList<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Arrays.fill(bool,false);
		list.offer(v);
		arr.add(v);
		bool[v] = true;

		int num = v;
		int j=0;
		while (!list.isEmpty()) {
			num = list.poll();
			for (int i = 1; i < check.length; i++) {
				if ((check[num][i] == 1) && !bool[i]) {
					list.offer(i);
					arr.add(i);
					bool[i] = true;
				}
			}
		}
		int[] answer = new int[arr.size()];
		int size = 0;
		for (int i : arr)
			answer[size++] = i;

		return answer;

	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), m = sc.nextInt(), v = sc.nextInt();

		boolean[] bool = new boolean[n + 1];
		int[][] check = new int[n + 1][n + 1];
		int num1, num2;

		for (int i = 0; i < m; i++) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			check[num1][num2] = 1;
			check[num2][num1] = 1;
		}
		int[] result = new int[check.length - 1];
		
		result = dfs(check, bool, v);
		for (int i : result)
			System.out.print(i+" ");
		System.out.println();
		
		result = bfs(check, bool, v);
		for (int i : result)
			System.out.print(i+" ");
	}
}