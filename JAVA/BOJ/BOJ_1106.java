package DP;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1106 {
	static int c,n;
	static int input[][];
	static int dp[][];
	static final int INF = 100*1005;
	static int cal(int depth ,int sum ) {
		if(sum >= c) return 0;
		if(depth >= n) {
			if(sum >= c) {
				return 0;
			}else {
				return INF;
			}
		}else {
			if(dp[depth][sum]!= -1) return dp[depth][sum];
			int result = INF;
			for(int i = 0 ; i <= c ; i++) {
				int temp = sum+input[depth][1]*i;
				result = Math.min(result, cal(depth+1,temp)+input[depth][0]*i);
				if(temp >= c) break;
			}
			dp[depth][sum] = result;
			return result;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt();
		n = sc.nextInt();
		input = new int[n][2];
		dp = new int[n][c+1];
		for(int i = 0 ; i < n ; i++) {
			Arrays.fill(dp[i], -1);
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}
		System.out.println(cal(0,0));
	}
}
