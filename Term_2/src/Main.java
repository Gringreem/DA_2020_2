import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int N = scan.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = random.nextInt();
		}
		
		int K = scan.nextInt();
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i<K; i++) {
			int a = random.nextInt(N) + 1;
			int b = random.nextInt(N) + 1;
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int sum = 0;
			
			if(a < b) {
				for(int j = a-1; j<b; j++) {
					if(arr[j] < min) {
						min = arr[j];
					}
					if(arr[j] > max) {
						max = arr[j];
					}
					sum += arr[j];
				}
			}
			else if(b < a) {
				for(int j = b-1; j<a; j++) {
					if(arr[j] < min) {
						min = arr[j];
					}
					if(arr[j] > max) {
						max = arr[j];
					}
					sum += arr[j];
				}
			}
			else {
				min = arr[a-1];
				max = arr[a-1];
				sum += arr[a-1];
			}
			
			System.out.println(min + " , "+max+" , "+sum);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Elapsed time is "+(end-start)+"ms");
		System.out.println(N +" , "+ K);
		
		scan.close();
	}

}
