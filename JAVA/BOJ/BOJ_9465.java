package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
	static int n;
	static int input[][];
	static int dp[][];
	static int dfs(int y , int x) {
		if(x >= n) return 0;
		else {
			if(dp[y][x] != -1) return dp[y][x];
			int result = 0;
			result = Math.max(result, dfs((y+1)%2,x+2));
			result = Math.max(result, dfs((y+1)%2,x+1));
			result += input[y][x];
			dp[y][x] = result;
			return result;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0 ; t < T ; t++) {
			st= new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			input = new int[2][n];
			dp = new int[2][n];
			for(int i = 0 ; i < 2 ; i++) {
				st= new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < n ; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = -1;
				}
			}
			int result = Math.max(dfs(0,0), dfs(1,0));
			System.out.println(result);
		}
	}
}
