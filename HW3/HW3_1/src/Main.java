import java.util.Scanner;
import java.util.Random;

public class Main {
	
	static void QSsort(int n) {
		
		Random rand = new Random();
		int head = 0, tail = n, top = -1;
		int size = 10000;
		int[] queue = new int[size];
		int[] stack = new int[n+1];
		
		for(int i = 0; i<n; i++) {
			queue[i] = rand.nextInt(size);
		}
		
		while(head != tail) {
			if(top == -1 || stack[top] > queue[head]) {
				stack[++top] = queue[head];
				head = (head+1) % size;
			}
			else {
				queue[tail] = stack[top--];
				tail = (tail+1) % size;
			}
		}
		
		for(int i = top; i >= 0 ; i--) {
			System.out.println(stack[i]);
		}
		
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("n을 입력하세요: ");
		
		int n = scan.nextInt();
		
		QSsort(n);
		scan.close();
	}

}
