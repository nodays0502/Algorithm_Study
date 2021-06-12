package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1202 {
	static int n, k;
	static int C[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->{
			return o2 - o1;
		});
		
		n = sc.nextInt();
		k = sc.nextInt();
		C = new int[k];
		List<int[]> input = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			int m = sc.nextInt();
			int v = sc.nextInt();
			input.add(new int[] {m,v});
		}
		for(int i = 0 ; i < k ; i++) {
			C[i] = sc.nextInt();
		}
		Collections.sort(input,(o1,o2)->{
			return o1[0] - o2[0];
		});
		Arrays.sort(C);
		long sum = 0;
		int index = 0;
		for(int i = 0 ; i < k ; i++) {
			while(index < n && input.get(index)[0] <= C[i]) {
				q.offer(input.get(index++)[1]);
			}
			if(!q.isEmpty())
				sum += q.poll();
	//		System.out.println(sum);
		}
		System.out.println(sum);
			
		
		
	}
}
