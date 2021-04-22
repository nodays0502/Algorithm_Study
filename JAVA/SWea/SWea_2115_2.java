package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_2115_2 {
	static int n, m,c;
	static int dp[][];
	static int map[][];
	static int dfs(int i , int j, int depth,int sum) {
		if(depth == m) return 0;
		int result = 0;
		if(sum+map[i][j] <= c)
			result = Math.max(result, dfs(i,j+1,depth+1,sum + map[i][j])) + map[i][j]*map[i][j];
		result = Math.max(result, dfs(i,j+1,depth+1,sum));
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t= 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			dp = new int[n][n];
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < n ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n-m+1 ; j++) {
					dp[i][j] = dfs(i,j,0,0);
				}
			}
			int result = 0;

			for(int ay = 0 ; ay < n ; ay++) {
				for(int ax = 0 ; ax < n-m+1 ; ax++) {
					int bx;
					for(int by = ay ; by < n ; by++) {
						if(by == ay) {
							bx = ax + m;
						}else {
							bx = 0 ;
						}
						for( ; bx < n-m+1 ; bx++) {
							result = Math.max(result,dp[ay][ax] + dp[by][bx]);
						}
					}
					
				}
			}
			System.out.printf("#%d %d\n" , t , result);
		}
		
	}

}
