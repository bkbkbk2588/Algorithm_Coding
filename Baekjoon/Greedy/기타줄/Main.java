import java.util.Scanner;

class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt(), brand = sc.nextInt(), answer = 0, one = Integer.MAX_VALUE, six = Integer.MAX_VALUE;
		int[][] arr = new int[brand][2];

		for (int i = 0; i < brand; i++) {
			six = Math.min(six, arr[i][0] = sc.nextInt());
			one = Math.min(one, arr[i][1] = sc.nextInt());
		}

		if (one * 6 < six)
			System.out.println(one * line);
		else {
			answer += six * (line / 6);
			line %= 6;

			if (line * one < six)
				System.out.println(answer + (line * one));
			else
				System.out.println(answer + six);
		}
	}
}
