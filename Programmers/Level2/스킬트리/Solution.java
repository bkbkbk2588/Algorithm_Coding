import java.util.Stack;

class Solution {
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		Stack<String> stack = new Stack<String>();
		Stack<String> temp = new Stack<String>();
		boolean flag;

		for (int i = 0; i < skill.length(); i++)
			stack.push(Character.toString(skill.charAt(i)));

		for (int i = 0; i < skill_trees.length; i++) {
			flag = true;
			for (int j = 0; j < skill_trees[i].length(); j++) {
				if (stack.contains(Character.toString(skill_trees[i].charAt(j))))
					temp.push(Character.toString(skill_trees[i].charAt(j)));
			}
			for (int k = 0; k < temp.size(); k++) {
				if (!stack.get(k).equals(temp.get(k)))
					flag = false;
			}
			if (flag)
				answer++;
			temp.removeAllElements();
		}
		return answer;
	}
}