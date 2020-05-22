import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Schedule implements Comparable<Schedule> {
	int enter = 0, work = 0;

	public Schedule(int enter, int work) {
		this.enter = enter;
		this.work = work;
	}

	@Override
	public int compareTo(Schedule o) {
		return Integer.compare(this.work, o.work);
	}
}

class Solution {
	public int solution(int[][] jobs) {
		int answer = 0, now = 0, result = 0, index = 1;
		PriorityQueue<Schedule> queue = new PriorityQueue<>();

		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] entry1, int[] entry2) {
                if (entry1[0] > entry2[0])
					return 1;
				else if (entry1[0] < entry2[0])
					return -1;
				else
					return Integer.compare(entry1[1], entry2[1]);
			}
		});

		queue.offer(new Schedule(jobs[0][0], jobs[0][1]));

		for (int cnt = 0; cnt < jobs.length; cnt++) {
			Schedule temp = queue.poll();
			int wait = now - temp.enter;

			if (wait < 0) {
				wait = 0;
				now = temp.enter + temp.work;
			}
			else
				now += temp.work;

			result = result + wait + temp.work;

			for (int i = index; i < jobs.length; i++) {
				if ((jobs[i][0] > now)) {
                    if(queue.isEmpty())
                        queue.offer(new Schedule(jobs[i][0], jobs[i][1]));
					index = i;
					break;
				}
				queue.offer(new Schedule(jobs[i][0], jobs[i][1]));

				if (i == jobs.length - 1)
					index = jobs.length;
			}
		}
		answer = result / jobs.length;
		return answer;
	}
}