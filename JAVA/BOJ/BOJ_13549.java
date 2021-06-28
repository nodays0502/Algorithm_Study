package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_13549 {
	static int n, k;

	static int bfs() {
		int result = Integer.MAX_VALUE;
		int cache[] = new int[200001];
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			return cache[o1] - cache[o2];
		});
		Arrays.fill(cache, -1);
		q.offer(n);
		cache[n] = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			int time = cache[now];
			System.out.println(now);
			System.out.println(cache[now]);
			if(now == k) {
				result = Math.min(result,time);
			}
			
			if(2*now <= 100000 && (cache[2*now] == -1 || cache[2*now] > time)) {
				cache[2*now] = time;
				q.offer(2*now);
			}
			
			if(now-1 >= 0 && (cache[now-1] == -1 || cache[now-1] > time+1)) {
				cache[now-1] = time+1;
				q.offer(now-1);
			}
			
			if(now+1 <= 100000 && (cache[now+1] == -1 || cache[now+1] > time+1)) {
				cache[now+1] = time+1;
				q.offer(now+1);
			}
			

		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		System.out.println(bfs());
	}
}
