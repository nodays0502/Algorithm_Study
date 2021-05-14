package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579 {
	static int n , m;
	static int M[];
	static int C[];
	static int dp[];
	static final int LIMIT = 987654321;
	static int dfs(int depth, int sum) {
		if(depth == n && sum < m) return LIMIT;
		if(sum >= m) return 0;
		if(dp[depth] != 0) return dp[depth];
		int result = LIMIT;
		result = Math.min(dfs(depth + 1 , sum), dfs(depth + 1 , sum + M[depth]) + C[depth]);
		dp[depth] = result;
		return result;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		M = new int[n];
		C = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ;i < n ; i++) {
			M[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ;i < n ; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dfs(0,0));
	}
}
