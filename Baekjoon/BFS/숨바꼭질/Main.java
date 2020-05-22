import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int su = sc.nextInt(), y = sc.nextInt(), answer = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(su);
		int[] visit = new int[100005];
		Arrays.fill(visit, -1);

		if (su >= y) {
			System.out.println(su - y);
			return;
		}

		while (!queue.isEmpty()) {
			int num = queue.poll();
			int[] temp = new int[3];
			temp[0] = num - 1;
			temp[1] = num + 1;
			temp[2] = num * 2;
			answer++;

			for (int i = 0; i < 3; i++) {
				if (temp[i] >= 0 && temp[i] <= 100000) {
					if (visit[temp[i]] == -1) {
						visit[temp[i]] = visit[num] + 1;
						queue.offer(temp[i]);
					}
				}
				if (temp[i] == y)
					break;
			}
		}
		
		System.out.println(visit[y]+1);
	}
}