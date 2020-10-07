import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		for (int tc = 0; tc < test; tc++) {
			int cnt = sc.nextInt(), index = sc.nextInt(), answer = 0;
			ArrayList<Integer> list = new ArrayList<>();
			Queue<int[]> queue = new LinkedList<>();

			for (int i = 0; i < cnt; i++) {
				int temp = sc.nextInt();
				queue.add(new int[] { temp, i });
				list.add(temp);
			}
			Collections.sort(list);
			Collections.reverse(list);

			while (!queue.isEmpty()) {
				int[] arr = queue.poll();
				if (arr[0] >= list.get(0)) {
					if (arr[1] == index) {
						System.out.println(answer + 1);
						break;
					} else {
						list.remove(0);
						answer++;
					}
				} else {
					queue.add(arr);
				}
			}
		}
	}
}
