package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ_2225 {
	static final int LIMIT = 1000000000;
	static int n , k ;
	static int dp[][];
	static int dfs(int now,int depth) {
//		System.out.println(now);
		if(now < 0 || depth > k) return 0;
		if(depth == k && now == 0) return 1;
		if(dp[now][depth] != -1) return dp[now][depth];
		int result = 0;
		for(int i = now ; i >= 0 ; i--) {
			result += (dfs(now - i, depth+1) % LIMIT);
			result %= LIMIT;
		}
		dp[now][depth] = result;
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n+1][k+1];
		for(int i = 0 ; i <= n; i++) {
			for(int j = 0 ; j <= k ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(n,0));
	}
}
