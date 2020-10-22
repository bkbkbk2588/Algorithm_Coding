import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
	static HashMap<Integer, ArrayList<int[]>> map;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt(), e = sc.nextInt(), start = sc.nextInt();
		int[][] info = new int[e][3];
		map = new HashMap<>();

		for (int i = 0; i < e; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();
			info[i][2] = sc.nextInt();
			if (!map.containsKey(info[i][0])) {
				ArrayList<int[]> temp = new ArrayList<>();
				temp.add(new int[] { info[i][1], info[i][2] });
				map.put(info[i][0], temp);
			} else {
				ArrayList<int[]> temp = map.get(info[i][0]);
				temp.add(new int[] { info[i][1], info[i][2] });
				map.put(info[i][0], temp);
			}
		}
		dijkstra(start, v);
	}

	static void dijkstra(int start, int size) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[1] - o2[1];
			}
		});

		int[] weight = new int[size + 1];
		Arrays.fill(weight, Integer.MAX_VALUE);
		queue.add(new int[] { start, 0 });
		weight[start] = 0;

		while (!queue.isEmpty()) {
			int index = queue.peek()[0], distance = queue.peek()[1];
			queue.poll();

			if (!map.containsKey(index))
				continue;
			
			ArrayList<int[]> graph = map.get(index);

			for (int i = 0; i < graph.size(); i++) {
				weight[graph.get(i)[0]] = Math.min(distance + graph.get(i)[1], weight[graph.get(i)[0]]);
				queue.add(new int[] { graph.get(i)[0], weight[graph.get(i)[0]] });
			}
			map.remove(index);
		}
		for (int i = 1; i < weight.length; i++) {
			if (weight[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else if (start == i)
				System.out.println(0);
			else
				System.out.println(weight[i]);
		}
	}
}
