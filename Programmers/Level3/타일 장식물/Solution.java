class Solution {
    public long solution(int N) {
		long[] arr = new long[N + 1];

		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;

		for (int i = 3; i <= N; i++)
			arr[i] = arr[i - 1] + arr[i - 2];

		return (arr[N] * 4) + (arr[N - 1] * 2);
	}
}