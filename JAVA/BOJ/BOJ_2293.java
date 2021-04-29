package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 {
	static int n, k ;
	static int dp[][];
	static int input[];
	static int dfs(int depth, int sum) {
		if(sum > k) return 0;
		else if(depth == n && sum == k)return 1;
		else if(depth >=n && sum != k) return 0;
		if(dp[depth][sum] != -1) return dp[depth][sum];
		int result = 0;
		for(int i = 0; sum + i * input[depth] <= k ; i++) {
			result += dfs(depth+1, sum + i * input[depth]);
		}
		dp[depth][sum] = result;
//		System.out.println(result);
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n][k+1];
		input = new int[n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j <= k ; j++) {
				dp[i][j] = -1;
			}
		}
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(dfs(0,0));
	}
}
