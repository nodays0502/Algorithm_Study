package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12761 {
	static boolean visited[] = new boolean[100001];
	static int A,B,N,M;
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static int bfs() {
		int result = -1;
		Queue<Integer> q = new LinkedList<>();
		visited[N] = true;
		q.offer(N);
		int cnt = 0 ;
		int move[] = {A,B,1};
		while(!q.isEmpty()) {
			int size= q.size();
			for(int s = 0 ; s < size; s++) {
				int now = q.poll();
//				System.out.println(now);
				if(now == M) return cnt;
				for(int i = 0 ; i < 3; i++) {
					for(int j = -1; j <= 1 ; j++) {
						if(j == 0 )continue;
						int nNow = now + j*move[i];
//						System.out.println("nNow:"+nNow);
						if(canMove(nNow)) { 
							q.offer(nNow);
						}
					}
				}
				if(canMove(A*now)) { 
					visited[A*now] = true;
					q.offer(A*now);
				}
				if(canMove(B*now)) { 
					visited[B*now] = true;
					q.offer(B*now);
				}
			}
			cnt++;
		}
		return result;
	}
	static boolean canMove(int now) {
		if(now > 100000 || now < 0) return false;
		if(!visited[now]) {
			visited[now] = true;
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		System.out.println(bfs());
	}
}
