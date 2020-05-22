import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, count = 0, ten, one, temp=0, sum = 0;
		String ssum, sone, stemp;
		num = sc.nextInt();
		temp=num;
		while(true) {
			if(temp==num && count>0)
				break;
			ten=temp/10;
			one=temp%10;
			sone=Integer.toString(one);
			sum=ten+one;
			sum=sum%10;
			ssum=Integer.toString(sum);
			stemp = sone.concat(ssum);
			temp = Integer.parseInt(stemp);
			count++;
			sum=0;

		}
		System.out.println(count);
	}
}