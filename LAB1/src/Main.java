import java.util.Scanner;

public class Main {
	static long sum(long n) {
		long sum = 0;
		if(n % 2 == 0) {
			sum = (1+n)*(n/2);
		}else {
			sum = (1+n)*(int)(n/2) + (int)(n/2) +1;
		}
		return sum;
		
//		for(int i = 1; i<n+1; i++) {
//			sum += i;
//		}
//		return sum;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long t = System.currentTimeMillis();
		System.out.println("Sum from 1 to "+n+" is "+sum(n));
		System.out.println("Elapsed time is "+(System.currentTimeMillis()-t)+"ms");
	}

}
