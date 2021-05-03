package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2193 {	
	static int n;
	static long dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long[2][n+11];
		dp[1][1] = 1; // 1
		dp[0][2] = 1; // 0
		for(int i = 3 ; i <= n ; i++) {
			dp[1][i] = dp[0][i-1];
			dp[0][i] = dp[1][i-1] + dp[0][i-1];
		}
		System.out.println(dp[1][n] + dp[0][n]);
	}
}	
