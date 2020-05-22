import java.util.HashMap;

class Solution {
	public String[] solution(String[] record) {
		int cnt = 0;
		String[][] temp = new String[record.length][3];
		HashMap<String, String> map = new HashMap();
		
		for (int i = 0; i < record.length; i++) {
			temp[i] = record[i].split(" ");
			
			if (temp[i][0].equals("Change"))
				cnt++;

			if(!record[i].substring(0,1).equals("L"))
				map.put(temp[i][1],temp[i][2]);
		}

		String[] answer = new String[record.length - cnt];
		int index = 0;
		
		for (int i = 0; i < record.length; i++) {
			if (temp[i][0].equals("Enter")) {
				answer[index] = map.get(temp[i][1]) + "님이 들어왔습니다.";
				index++;
			} else if (temp[i][0].equals("Leave")) {
				answer[index] = map.get(temp[i][1]) + "님이 나갔습니다.";
				index++;
			}

		}
		return answer;
	}
}