import java.util.ArrayList;

class Solution {
	public int solution(int[] nums) {
		int size = nums.length / 2;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i : nums) {
			if (!list.contains(i))
				list.add(i);
		}
		return size <= list.size() ? size : list.size();
	}
}