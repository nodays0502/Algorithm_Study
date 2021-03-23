package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11726 {
	static int dp[];
	static final int LIMIT = 10007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2 ; i <= n ; i++) {
			dp[i] = (dp[i-1] + dp[i-2]);
			dp[i] %= LIMIT;
		}
		System.out.println(dp[n]);
	}
}
