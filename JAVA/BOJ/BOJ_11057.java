package BOJ;

import java.util.Scanner;

public class BOJ_11057 {
	static int n ;
	static int dp[][];
	static final int LIMIT = 10007;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+1][10];
		for(int i = 0 ; i < 10 ;  i++) {
			dp[1][i] = 1;
		}
		int result = 0;
		for(int i = 2; i <= n; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				for(int  k = j ; k < 10 ; k++) {
					dp[i][j] += (dp[i-1][k] % LIMIT);
					dp[i][j] %= LIMIT;
				}
			}
		}
		for(int i = 0 ; i < 10 ; i++) {
			result += dp[n][i];
		}
		System.out.println(result);
	}
}
