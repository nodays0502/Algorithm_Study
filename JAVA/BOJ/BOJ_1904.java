package DP;

import java.util.Scanner;

public class BOJ_1904 {
	static int n;
	static int dp[];
	static final int limit = 15746;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+5];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3 ; i <= n ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
	}
}
