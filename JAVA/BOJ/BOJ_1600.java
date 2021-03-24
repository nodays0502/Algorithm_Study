package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
	static int k,n,m;
	static int input[][];
	static int dp[][][];
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static int sdy[] = {-2,-1,1,2,2,1,-1,-2};
	static int sdx[] = {1,2,2,1,-1,-2,-2,-1};
	
	static int result = 0;
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,0});
		int result = -1;
		while(!q.isEmpty()) {
//			print();
			int now[] = q.poll();
			int cnt = dp[now[0]][now[1]][now[2]];
			int check = now[2];
			if(now[0] == n-1 && now[1] == m-1) {result = cnt; break;}
			for(int i = 0 ; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && dp[ny][nx][check] == 0 && input[ny][nx] == 0) {
					dp[ny][nx][check] = cnt+1;
					q.offer(new int[] {ny,nx,check});
				}
			}
			if(check < k) {
				check++;
				for(int i = 0 ; i < 8; i++) {
					int ny = now[0] + sdy[i];
					int nx = now[1] + sdx[i];
					if(nx >=0 && nx < m && ny >=0 && ny < n && dp[ny][nx][check] == 0 && input[ny][nx] == 0) {
						dp[ny][nx][check] = cnt+1;
						q.offer(new int[] {ny,nx,check});
					}
				}
			}
		}
		return result;
	}
	static void print(){
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				System.out.print(dp[i][j][0]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				System.out.print(dp[i][j][1]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		input = new int[n][m];
		dp = new int[n][m][k+1];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < m ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());

	}
}
