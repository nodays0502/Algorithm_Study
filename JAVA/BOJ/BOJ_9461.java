package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9461 {
	static int n;
	static long dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;
		for(int i = 7 ; i < 101 ; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T ; t++) {
			n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
