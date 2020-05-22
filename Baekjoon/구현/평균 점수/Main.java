import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []num = new int[5];
		int sum=0, avg=0;
		
		for(int i=0;i<5;i++) {
			num[i]=sc.nextInt();
			if(num[i]<40) {
				num[i]=40;
			}
			sum+=num[i];
		}
		avg = sum/5;
		System.out.println(avg);
	}
}
