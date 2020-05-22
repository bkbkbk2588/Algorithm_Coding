import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public int solution(int[] citations) {
		int answer = 0, index = 1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.sort(citations);

		for (int i = citations.length - 1; i >= 0; i--)
			map.put(index++, citations[i]);

        index = 1;
		while (map.get(index) >= index) {
			answer++;
            index++;
            if(index>map.size())
				break;
        }
		return answer;
	}
}