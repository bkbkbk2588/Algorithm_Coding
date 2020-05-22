import java.util.Arrays;

class Solution {
	public int solution(int[] arr) {
		int result = 0, index = 2, cnt = 0, length = arr.length;
		Arrays.sort(arr);

		while (true) {
			result = arr[length - 1] * index;
			index++;
			for (int i = 0; i < length - 1; i++) {
				if (result % arr[i] == 0)
					cnt++;
				else
					break;
			}
			
			if(cnt == length-1)
				break;
            cnt = 0;
		}
		return result;
	}
}
