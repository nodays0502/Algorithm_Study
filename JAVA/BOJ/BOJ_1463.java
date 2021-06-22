package DP;

import java.util.Scanner;

public class BOJ_1463 {
	static int n;
	static int dp[];
	static int dfs(int num) {
		if(num == 1 )return 0;
		else {
			if(dp[num] != 0) return dp[num];
			int result = 1000001;
			if(num % 3 == 0) result = Math.min(result,dfs(num/3)+1);
			if(num % 2 == 0) result = Math.min(result,dfs(num/2)+1);
			result = Math.min(result, dfs(num-1)+1);
			return result;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 dp = new int[n+1];
		 System.out.println(dfs(n));
	}
}
