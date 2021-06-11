package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_11286 {
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->{
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			if(a == b) {
				return o1 - o2;
			}else {
				return a - b;
			}
		}); 
		for(int i = 0 ; i < n ; i++) {
			int temp = sc.nextInt();
			if(temp == 0) {
				if(!q.isEmpty())
					System.out.println(q.poll()); 
				else
					System.out.println(0);
			}
			else
				q.offer(temp);
		}

	}
}
