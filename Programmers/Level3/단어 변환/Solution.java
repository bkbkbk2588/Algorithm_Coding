class Solution {
    public int solution(String begin, String target, String[] words) {
   int answer = 0, num = 0, index = 0;
		int size = words[0].length();
		boolean[] visit = new boolean[words.length];

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				index = i;
				num++;
			}
		}

		if (num == 0)
			return 0;

		for (int i = 0; i < words.length; i++) {
			int cnt = size - 1;

			if (visit[i])
				continue;

			for (int j = 0; j < size; j++) {
				if (begin.charAt(j) == words[index].charAt(j))
					cnt--;
			}
			if (cnt == 0)
				return ++answer;

			cnt = size - 1;
			
			for (int j = 0; j < size; j++) {
				if (begin.charAt(j) == words[i].charAt(j))
					cnt--;
			}
			if (cnt == 0) {
				visit[i] = true;
				begin = words[i];
			    answer++;
			}
		}
		return answer;
	}
}