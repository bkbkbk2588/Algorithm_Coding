import java.util.Arrays;

class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String[] temp = new String[n];
		Arrays.fill(answer, "");

		for (int i = 0; i < n; i++)
			temp[i] = Integer.toBinaryString(arr1[i] | arr2[i]);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < temp[i].length(); j++) {
				if (temp[i].charAt(j) == '1')
					answer[i] += "#";
				else
					answer[i] += " ";
			}

			if (answer[i].length() != n) {
				for (int j = answer[i].length(); j < n; j++)
					answer[i] = " " + answer[i];
			}
		}

		return answer;
	}
}
