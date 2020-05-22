import java.util.Arrays;

class Solution {
	public int[] solution(int N, int[] stages) {
		int size = stages.length, tmp = 0, index = 0;
		int[] answer = new int[N];
		double[] temp = new double[N + 1];
		double max = -1;

		Arrays.fill(temp, 0);

		for (int i = 0; i < size; i++) {
			if (stages[i] != N + 1)
				temp[stages[i]]++;
		}

		for (int i = 0; i <= N; i++) {
			tmp = (int) temp[i];
			temp[i] /= size;
			size -= tmp;
            if (size == 0)
				break;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= N; j++) {
				if (max < temp[j]) {
					max = temp[j];
					index = j;
				}
			}
			answer[i] = index;
			temp[index] = -1;
			max = -1;
		}
		return answer;
	}
}
