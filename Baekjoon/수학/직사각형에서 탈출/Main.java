import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, w, h, min=1000;
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		int []arr=new int[4];
		arr[0]=x;
		arr[1]=y;
		arr[2]=w-x;
		arr[3]=h-y;
		for(int i=0;i<4;i++) {
			if(min>arr[i]) {
				min=arr[i];
			}
		}
		System.out.println(min);
	}
}