package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11727 {
	static int dp[];
	static final int LIMIT = 10007;
	static int n;
	static int cal(int now) {
		if(dp[now] != 0 )return dp[now];
		dp[now] = (cal(now-1) + 2 * cal(now-2))%LIMIT;
		return dp[now];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		System.out.println(cal(n));
	}

}
