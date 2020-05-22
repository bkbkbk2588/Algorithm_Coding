import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public static String[] solution(String[] files) {
		String[] answer = new String[files.length];
		Sorting[] sorting = new Sorting[files.length];

		for (int i = 0; i < files.length; i++) {
			sorting[i] = new Sorting(files[i]);
		}

		Arrays.sort(sorting, new Comparator<Sorting>() {
			@Override
			public int compare(Sorting s1, Sorting s2) {
				if (!s1.head.toUpperCase().equals(s2.head.toUpperCase()))
					return s1.head.toUpperCase().compareTo(s2.head.toUpperCase());
				else {
					if (Integer.parseInt(s1.number) < Integer.parseInt(s2.number))
						return -1;

					else if (Integer.parseInt(s1.number) > Integer.parseInt(s2.number))
						return 1;
				}
				return 0;
			}
		});

		for (int i = 0; i < files.length; i++) {
			answer[i] = sorting[i].head + sorting[i].number + sorting[i].tail;
			System.out.println(answer[i]);
		}

		return answer;
	}
}

class Sorting {
	String head = "";
	String number = "";
	String tail = "";
	boolean[] check = new boolean[3];

	Sorting(String files) {
		check[0] = true;

		for (int j = 0; j < files.length(); j++) {
			if ((files.charAt(j) < 48) || (files.charAt(j) > 57)) {
				if (check[0])
					head += files.charAt(j);

				else if (check[1]) {
					check[1] = false;
					check[2] = true;
					tail += files.charAt(j);
				}

				else
					tail += files.charAt(j);
			} else {
				if (check[0]) {
					check[0] = false;
					check[1] = true;
					number += files.charAt(j);
				} else if (check[1])
					number += files.charAt(j);
				else
					tail += files.charAt(j);
			}
		}
	}
}