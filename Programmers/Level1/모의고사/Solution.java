import java.util.Arrays;

class Solution {
	public int[] solution(int[] answers) {
		int[] answer = new int[4];
		int[] one = { 1, 2, 3, 4, 5 };
		int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int cnt1 = 0, cnt2 = 0, cnt3 = 0, max = -1, num = 0;

		for (int i = 0; i < 4; i++)
			answer[i] = 0;

		for (int i = 0; i < answers.length; i++) {
			if (one[cnt1] == answers[i]) {
				answer[1]++;
				if (max < answer[1])
					max = answer[1];
			}
			if (two[cnt2] == answers[i]) {
				answer[2]++;
				if (max < answer[2])
					max = answer[2];
			}
			if (three[cnt3] == answers[i]) {
				answer[3]++;
				if (max < answer[3])
					max = answer[3];
			}
			cnt1++;
			cnt2++;
			cnt3++;
			if (cnt1 == 5)
				cnt1 = 0;
			if (cnt2 == 8)
				cnt2 = 0;
			if (cnt3 == 10)
				cnt3 = 0;
		}

		for (int i = 1; i < 4; i++) {
			if (max == answer[i])
				num++;
		}

		int[] arr = new int[num];
		int n = 0;
		for (int i = 1; i < 4; i++) {
			if (max == answer[i]) {
				arr[n] = i;
				n++;
			}
		}
		return arr;
	}
}
