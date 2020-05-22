import java.util.ArrayList;

class Solution {
	ArrayList<Integer> list = new ArrayList<>();
	int[] answer;
	int index = 0;

	long turn(int n, long k) {
		long num = 1;

		for (int i = 1; i < n; i++)
			num *= i;

		int temp = 0;

		if (k % num == 0)
			temp = (int) (k / num);
		else
			temp = (int) (k / num) + 1;

		answer[index] = list.get(temp - 1);
		list.remove(temp - 1);
		index++;

		if (1 < temp)
			return k - (num * (temp - 1));
		else
			return k;
	}

	public int[] solution(int n, long k) {
		long num = k;
		answer = new int[n];

		for (int i = 1; i <= n; i++)
			list.add(i);

		for (int i = 0; i < n; i++)
			num = turn(list.size(), num);

		return answer;
	}
}