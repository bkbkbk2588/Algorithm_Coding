import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] graph;
	static boolean[] visit;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int vertex = sc.nextInt(), edge = sc.nextInt(), answer = 0;
		graph = new int[vertex + 1][vertex + 1];
		visit = new boolean[vertex + 1];

		for (int i = 0; i < edge; i++) {
			int u = sc.nextInt(), v = sc.nextInt();

			graph[u][v] = 1;
			graph[v][u] = 1;
		}

		for (int i = 1; i <= vertex; i++) {
			if (!visit[i]) {
				answer++;
				bfs(i);
			}
		}
		
		System.out.println(answer);
	}

	static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(x);
		visit[x] = true;

		while (!queue.isEmpty()) {
			int index = queue.poll();

			for (int i = 1; i < graph.length; i++) {
				if (graph[index][i] == 1 && !visit[i]) {
					queue.add(i);
					visit[i] = true;
				}
			}

		}
	}
}
