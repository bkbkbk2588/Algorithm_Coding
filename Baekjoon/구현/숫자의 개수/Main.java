import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3, mul;
		int []result=new int[10];
		for(int i=0;i<result.length;i++) {
			result[i]=0;
		}
		int []ri;
		String temp;
		String rs[];
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		mul = num1*num2*num3;
		temp=Integer.toString(mul);
		rs=temp.split("");
		ri=new int[rs.length];
		
		for(int i=0; i<rs.length;i++) {
			ri[i] = Integer.parseInt(rs[i]);
		}
		
		for(int i=0; i<ri.length; i++) {
			if(ri[i]==0)
				result[0]+=1;
			else if(ri[i]==1)
				result[1]+=1;
			else if(ri[i]==2)
				result[2]+=1;
			else if(ri[i]==3)
				result[3]+=1;
			else if(ri[i]==4)
				result[4]+=1;
			else if(ri[i]==5)
				result[5]+=1;
			else if(ri[i]==6)
				result[6]+=1;
			else if(ri[i]==7)
				result[7]+=1;
			else if(ri[i]==8)
				result[8]+=1;
			else if(ri[i]==9)
				result[9]+=1;
		}
		for(int i=0; i<10; i++) {
			System.out.println(result[i]);
		}
	}
}