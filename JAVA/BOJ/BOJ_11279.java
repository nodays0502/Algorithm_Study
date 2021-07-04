import java.util.PriorityQueue;
import java.util.Scanner;
public class BOJ_11279 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)-> {
			return o2-o1;
		});
		int n = sc.nextInt();
		for(int i = 0 ; i < n ; i++) {
			int temp = sc.nextInt();
			if(temp == 0) {
				if(q.isEmpty())sb.append(0);
				else sb.append(q.poll());
				sb.append('\n');
			}else {
				q.offer(temp);
			}
		}
		System.out.println(sb);
	}
}
