import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int solution(int[][] routes) {
		int answer = 1;
		ArrayList<Integer> list = new ArrayList<>();
		
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] entry1, int[] entry2) {
				return Integer.compare(entry1[0], entry2[0]);
			}
		});
		
		list.add(routes[0][0]);
		list.add(routes[0][1]);
		
		for(int i = 1; i < routes.length; i++) {
			int size = list.size(), num = 0;

			for (int j = 0; j < size; j += 2) {
				if (routes[i][0] >= list.get(j) && routes[i][0] <= list.get(j + 1))
					num += 2;
			}

			if (num != size) {
				list.clear();
				answer++;
			}
			list.add(routes[i][0]);
			list.add(routes[i][1]);
		}
		return answer;
	}
}