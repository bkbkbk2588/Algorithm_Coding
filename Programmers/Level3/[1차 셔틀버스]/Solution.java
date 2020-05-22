import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		int hour = 9, minitue = 0, index = 0, arr_index = 0;
		int h_temp = 0, m_temp = 0;
		boolean flag = false;
		ArrayList<Boolean> visit = new ArrayList<>();
		Arrays.sort(timetable);

		for (int i = 0; i < m; i++)
			visit.add(false);

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				h_temp = Integer.parseInt(timetable[index].substring(0, 2));
				m_temp = Integer.parseInt(timetable[index].substring(3));

				if ((hour > h_temp) || ((hour == h_temp) && (minitue >= m_temp))) {
					index++;
					if (i == n) {
						visit.set(arr_index, true);
						arr_index++;
					}
				}

				if (timetable.length - index == 0) {
					if (j < m - 1) {
						flag = true;
                        visit.set(arr_index, true);
						break;
					}
					m_temp--;
					if (m_temp < 0) {
						m_temp = 59;
						h_temp--;
					}
					return String.format("%02d", h_temp) + ":" + String.format("%02d", m_temp);
				}
			}
			if (i == n)
				break;
			minitue += t;
			hour += (minitue / 60);
			minitue = minitue % 60;
		}

		if (flag || visit.contains(false))
			answer = String.format("%02d", hour) + ":" + String.format("%02d", minitue);
		else {
			m_temp--;
			if (m_temp < 0) {
				m_temp = 59;
				h_temp--;
			}
			answer = String.format("%02d", h_temp) + ":" + String.format("%02d", m_temp);
		}

		return answer;
	}
}