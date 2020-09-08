import java.util.Scanner;

class Solution {

	public String solution(String p) {
		String answer = "";
		if (p.equals(""))
			return "";

		if (confirm(p))
			return p;
		else
			answer = decomposition(p);

		System.out.println(answer);

		return answer;
	}

	String decomposition(String str) {
		String u = "", v = "";
		int[] count = new int[2];
		boolean flag = false;

		for (int i = 0; i < str.length(); i++) {
			if (count[0] == count[1] && count[0] != 0)
				flag = true;
			if (!flag) {
				u += Character.toString(str.charAt(i));
				if (str.charAt(i) == '(')
					count[0]++;
				else
					count[1]++;
			} else
				v += Character.toString(str.charAt(i));
		}

		/////////// 이 부분 수정 요망////////////
		return algo(u, v);
		/////////////////////////////////////
	}

	String algo(String u, String v) {
		String temp = "";
		if (confirm(u)) {
			if (confirm(v))
				return u + v;
			// answer += (u + v);
			else
				temp += u + decomposition(v);// first
		} else {
			temp = "(";
			temp += decomposition(v);
			temp += ")";

			for (int i = 1; i < u.length() - 1; i++) {
				if (u.charAt(i) == '(')
					temp += ")";
				else
					temp += "(";
			}
		}
		return temp;
	}

	boolean confirm(String u) {
		int[] count = new int[2];

		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(')
				count[0]++;
			else
				count[1]++;

			if (count[1] > count[0])
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution s = new Solution();

		s.solution("()))((()");
	}
}
