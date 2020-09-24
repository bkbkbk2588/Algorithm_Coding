import java.util.Scanner;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int student = sc.nextInt(), count = sc.nextInt(), answer = 0;
		int[] man = new int[7];
		int[] girl = new int[7];

		for (int i = 0; i < student; i++) {
			int sex = sc.nextInt(), grade = sc.nextInt();

			if (sex == 0)
				girl[grade]++;
			else
				man[grade]++;
		}

		for (int i = 1; i < 7; i++) {
			if (girl[i] % count != 0)
				answer++;
			if (man[i] % count != 0)
				answer++;

			answer += girl[i] / count;
			answer += man[i] / count;
		}
		System.out.println(answer);
	}
}
