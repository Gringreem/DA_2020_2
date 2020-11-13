import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		int[] queue = new int[100000];
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int num_push = 0;
		
		int head = 0, tail = 0;
		
		for(int i = 0; i<n; i++) {
			String command = scan.next();
			
			if(command.equals("push")) {
				num_push = scan.nextInt();
				queue[tail++] = num_push;
			}else if(command.equals("pop")) {
				System.out.println(head==tail?-1:queue[head++]);
			}else if(command.equals("size")) {
				System.out.println(tail - head);
			}else if(command.equals("empty")) {
				System.out.println(head==tail?1:0);
			}else if(command.equals("front")) {
				System.out.println(head==tail?-1:queue[head]);
			}else if(command.equals("back")) {
				System.out.println(head==tail?-1:queue[tail]);
			}
		}
		scan.close();
		
	}

}
