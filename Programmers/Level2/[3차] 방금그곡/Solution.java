class Solution {
	public static String solution(String m, String[] musicinfos) {
		String answer = "";
		String[] temp;
		String music = "";
		int hours = 0, minute = 0, length = 0, index = 0, max = 0;

		m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")
				.replace("E#", "e");

		for (int i = 0; i < musicinfos.length; i++) {
			musicinfos[i] = musicinfos[i].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g")
					.replace("E#", "e").replace("A#", "a");
			temp = musicinfos[i].split(",");

			
			String[] start = temp[0].split(":");
			String[] end = temp[1].split(":");
			hours = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
			minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
			length = minute + (hours * 60);

			for (int j = 0; j < length; j++) {
				if (index == temp[3].length()) {
					index = 0;
					music += temp[3].charAt(index);
					index++;
				} else {
					music += temp[3].charAt(index);
					index++;
				}
			}

			if (music.contains(m)) {
				if (max < length) {
					max = length;
					answer = temp[2];
				}
			}

			hours = 0;
			minute = 0;
			length = 0;
			index = 0;
			music = "";
		}

		if (answer.equals(""))
			answer = "(None)";

		return answer;
	}
}