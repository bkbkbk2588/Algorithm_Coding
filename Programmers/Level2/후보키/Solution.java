import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Solution {
	public int solution(String[][] relation) {
		int answer = 0, rowsize = relation.length, colsize = relation[0].length;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i < (1 << colsize); i++) {
			if (check(rowsize, colsize, relation, i))
				list.add(i);
		}

		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				int x = countbit(a), y = countbit(b);

				if (x > y)
					return 1;
				else if (x < y)
					return -1;
				else
					return 0;
			}
		});

		while (list.size() != 0) {
			int num = list.remove(0);
			answer++;

			for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
				int a = it.next();
				if ((num & a) == num)
					it.remove();
			}
		}

		return answer;
	}

	int countbit(int num) {
		int count = 0;

		while (num != 0) {
			if ((num & 1) == 1)
				count++;
			num = num >> 1;
		}

		return count;
	}

	boolean check(int rowsize, int colsize, String[][] relation, int subset) {
		for (int i = 0; i < rowsize - 1; i++) {
			for (int j = i + 1; j < rowsize; j++) {
				boolean flag = true;
				for (int k = 0; k < colsize; k++) {
					if ((subset & (1 << k)) == 0)
						continue;
					if (!relation[i][k].equals(relation[j][k])) {
						flag = false;
						break;
					}
				}
				if (flag)
					return false;
			}
		}
		return true;
	}
}