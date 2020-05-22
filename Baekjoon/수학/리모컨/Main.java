import java.util.Scanner;

public class Main {

	int count(int channel, int[] error, int len) {
		int cnt1 = 500000, cnt2 = 500000, sw = 0, cntnum = 1, temp;
		String str;

		if (len == 10) {
			cnt1 = Math.abs(100 - channel);
			return cnt1;
		}

		for (int i = channel; i >= 0; i--) {
			temp = i;
			str = Integer.toString(i);

			for (int j = 0; j < len; j++) {
				if (len == 10)
					break;
				if (str.contains(Integer.toString(error[j]))) {
					sw = 1;
					break;
				}
			}

			if (sw == 1)
				sw = 0;

			else if (sw == 0) {
				int cntemp1, cntemp2;
				while (temp / 10 != 0) {
					temp /= 10;
					cntnum++;
				}

				cntemp1 = Math.abs(100 - channel);
				cntemp2 = cntnum + (channel - i);
				cnt1 = cntemp1 < cntemp2 ? cntemp1 : cntemp2;

				break;
			}
		}

		sw = 0;
		cntnum = 1;

		for (int k = channel + 1; k < 1000001; k++) {
			temp = k;
			str = Integer.toString(k);
			for (int j = 0; j < len; j++) {
				if (len == 10)
					break;
				if (str.contains(Integer.toString(error[j]))) {
					sw = 1;
					break;
				}
			}
			if (sw == 1)
				sw = 0;
			else if (sw == 0) {
				while (temp / 10 != 0) {
					temp /= 10;
					cntnum++;
				}
				cnt2 = cntnum + Math.abs(k - channel);
				break;
			}
		}
		return cnt1 <= cnt2 ? cnt1 : cnt2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int channel = sc.nextInt(), error = sc.nextInt(), cnt = 0;
		int[] number = new int[error];
		Main main = new Main();
		for (int i = 0; i < error; i++)
			number[i] = sc.nextInt();
		cnt = main.count(channel, number, error);
		System.out.println(cnt);
	}
}