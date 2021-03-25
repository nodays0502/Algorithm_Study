package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261 {
	static int n , m;
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static int dp[][];
	static int input[][];
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0,0});
		dp[0][0] = 0;
		int result = 0 ;
		while(!q.isEmpty()) {
	//		print();
	//		System.out.println();
			int[] now = q.poll();
			int cnt = dp[now[0]][now[1]];
			if(now[0] == n-1 && now[1] == m-1) {result = Math.min(cnt, result);}
			for(int i = 0 ; i < 4 ; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
	//			if(nx == 2 && ny == 2) {System.out.println(dp[ny][nx] +" "+ cnt +" "+ input[ny][nx]);}
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && (dp[ny][nx] == -1 || dp[ny][nx] > cnt + input[ny][nx] )) {
					q.offer(new int[] {ny,nx});
					dp[ny][nx] = cnt + input[ny][nx];					
				}
			}
		}	
		return result;
	}
	static void print() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		input = new int[n][m];
		dp = new int[n][m];
		for(int i = 0 ; i < n ; i++) {
			String command = br.readLine();
			for(int j = 0 ; j < m ; j++) {
				input[i][j] = command.charAt(j)-'0';
				dp[i][j] = -1;
			}
		}
		System.out.println(bfs());
//		print();
	}
}
