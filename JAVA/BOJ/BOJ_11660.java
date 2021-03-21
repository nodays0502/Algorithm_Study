package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {
	static int n , m;
	static int input[][];
	static int dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		int temp = 0 ;
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1 ; j <= n ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + input[i][j];
			}
		}
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			System.out.println(dp[y2][x2] - dp[y2][x1 - 1] - dp[y1 - 1][x2] + dp[y1 - 1][x1 - 1]);
		}
	}
}
