import java.util.ArrayList;

class Solution {
	public static int solution(String str1, String str2) {
		int answer = 0, size = 0, size1 = 0, size2 = 0;
		double same = 0, all = 0;
		String temp;
		boolean turn = false;
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		

		for (int i = 0; i < str1.length() - 1; i++) {
			temp = str1.substring(i, i + 2);
			if (((temp.charAt(0) >= 65 && temp.charAt(0) <= 90) || (temp.charAt(0) >= 97 && temp.charAt(0) <= 122))
					&& ((temp.charAt(1) >= 65 && temp.charAt(1) <= 90)
							|| (temp.charAt(1) >= 97 && temp.charAt(1) <= 122)))
				list1.add(temp.toUpperCase());
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			temp = str2.substring(i, i + 2);
			if (((temp.charAt(0) >= 65 && temp.charAt(0) <= 90) || (temp.charAt(0) >= 97 && temp.charAt(0) <= 122))
					&& ((temp.charAt(1) >= 65 && temp.charAt(1) <= 90)
							|| (temp.charAt(1) >= 97 && temp.charAt(1) <= 122))) 
				list2.add(temp.toUpperCase());
		}

		size1 = list1.size();
		size2 = list2.size();
		
		if (list1.size() > list2.size())
			size = list2.size();
		else {
			size = list1.size();
			turn = true;
		}

		for (int i = 0; i < size; i++) {
			if (!turn) {
				if (list1.contains(list2.get(i))) {
					list1.remove(list2.get(i));
					same++;
				}
			} else {
				if (list2.contains(list1.get(i))) {
					list2.remove(list1.get(i));
					same++;
				}
			}
		}
		
		all = (size1 - same) + (size2 - same) + same;
		
		if (all == 0 && same == 0)
			answer = 65536;
		else
			answer = (int) Math.floor((same / all)*65536);

		return answer;
	}
}