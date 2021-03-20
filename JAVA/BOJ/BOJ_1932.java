package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
	static int n;
	static int input[][];
	static int dp[][];
	static int result = 0;
	static int dfs(int y ,int x ) {
		if(y == n -1) {
			return input[y][x];
		}else {
			if(dp[y][x] != -1) return dp[y][x];
			int result = 0 ;
			result = dfs(y+1,x);
			result = Math.max(result,dfs(y+1,x+1));
			result += input[y][x];
			dp[y][x] = result;
			return result;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n][n];
		dp = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j <= i ; j++) {
				dp[i][j] = -1;
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0,0));
	}
}
