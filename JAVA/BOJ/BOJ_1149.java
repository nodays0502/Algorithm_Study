package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
	static int n;
	static int input[][];
	static int dp[][];
/*	static int dfs(int depth,int color) {
		if(depth == n-1) {
			return 0;
		}
		int result = Integer.MAX_VALUE;
		if(depth != -1 && dp[depth][color] != 0 ) return dp[depth][color];
		for(int i = 0 ; i < 3 ; i++) {
			if(i != color) {
				result = Math.min(result, dfs(depth+1,i) + input[depth+1][i]);
			}
		}
		if(depth != -1)
			dp[depth][color] = result;
		return result;
	}*/
	static int dfs(int depth,int color) {
		if(depth == n) {
			return 0;
		}
		int result = Integer.MAX_VALUE;
		if(dp[depth][color] != 0 ) return dp[depth][color];
		for(int i = 0 ; i < 3 ; i++) {
			if(i != color) {
				result = Math.min(result, dfs(depth+1,i) + input[depth][color]);
			}
		}
		dp[depth][color] = result;
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n][3];
		dp = new int[n][3];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < 3; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < 3 ; i++) {
			dp[0][i] = input[0][i];
		}
		for(int i = 1 ; i < n ; i++) {
			for(int j = 0 ; j < 3; j++) {
				int temp = Integer.MAX_VALUE;
				for(int k = 0 ; k < 3 ; k++) {
					if(j!= k) {
						temp = Math.min(temp, dp[i-1][k]);
					}
				}
				if(i == 0 )temp = 0 ;
				dp[i][j] = input[i][j] + temp;
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i = 0 ; i < 3 ; i++) {
			result = Math.min(result, dp[n-1][i]);
		}
		System.out.println(result);
	/*	int result = Integer.MAX_VALUE;
		for(int i = 0 ; i < 3; i++) {
			result = Math.min(result, dfs(0,i));
		}
		System.out.println(result);*/
	//	System.out.println(dfs(-1,-1));
	}
}
