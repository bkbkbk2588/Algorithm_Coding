import java.util.Arrays;

class Solution {
	public int solution(int[] nums) {
		int answer = 0;
		int sum = 0;
		Arrays.sort(nums);
		sum = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
		boolean[] arr = new boolean[sum + 1];

		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false;

		for (int i = 2; i <= sum; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					arr[i] = false;
					break;
				}

			}
		}

		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					sum = nums[i]+nums[j]+nums[k];
					if(arr[sum])
						answer++;
				}
			}
		}
		return answer;
	}
}