import java.util.HashMap;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - (reserve.length + lost.length);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> los = new HashMap<Integer, Integer>();

		for (int i = 0; i < reserve.length; i++)
			map.put(reserve[i], i);

		for (int i = 0; i < lost.length; i++)
			los.put(lost[i], i);

		for (int i = 0; i < lost.length; i++) {
            
            if(map.containsKey(lost[i])){
				answer++;
              //map.remove(lost[i]);  
            }
			else if (map.containsKey(lost[i] + 1) && !los.containsKey(lost[i] + 1)) {
				answer += 2;
				map.remove(lost[i] + 1);

			}
			else if (map.containsKey(lost[i] - 1) && !los.containsKey(lost[i] - 1)) {
				answer += 2;
				map.remove(lost[i] - 1);
			}
		}
		answer += map.size();
		return answer;
	}
}
