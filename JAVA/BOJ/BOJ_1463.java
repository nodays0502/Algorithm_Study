package DP;

import java.util.Scanner;

public class BOJ_1463 {
	static int n ;
	static int dp[] = new int[n+1];
	static int dfs(int num) {
		if(num == 1) return 0;
		if(dp[num] != 0 ) return dp[num];
//		System.out.println(num);
		
		int result = Integer.MAX_VALUE;
		result = Math.min(result, dfs(num - 1) + 1);
		if(num % 3 == 0) result = Math.min(result, dfs(num / 3) + 1);
		if(num % 2 == 0) result = Math.min(result, dfs(num / 2) + 1);
		dp[num] = result;
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		System.out.println(dfs(n));
//		System.out.println(Arrays.toString(dp));
/*		for(int i = 2 ; i <= n ; i++) {
			dp[i] = dp[i-1] + 1;
			if(i >= 3 && i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
			if(i >= 2 && i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
		}
		System.out.println(dp[n]);*/
	}
}
