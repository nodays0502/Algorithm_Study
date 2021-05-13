package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
	static int n,k;
	static int M[];
	static int V[];
	static int C[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		C = new int[k];
		PriorityQueue<Integer> q[] = new PriorityQueue[k];
		List<int[]> list = new ArrayList();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new int[] {m,v});
		}
		Collections.sort(list,(o1,o2) -> {
			return o1[0] - o2[0]; // 
		});
		for(int i = 0 ; i < k ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			C[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(C);
		long result = 0;
		int index = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> {return o2-o1;});
		for(int i = 0 ; i < k ; i++) {
			while(index < n && list.get(index)[0] <= C[i]) {
				pq.offer(list.get(index++)[1]);
			}
			if(!pq.isEmpty()) {
				result += pq.poll();
			}
		}
		System.out.println(result);
	}
}
