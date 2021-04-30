package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12869 {
	static int n;
	static int hp[];
	static int dp[][][];
	static int dfs(int a , int b , int c) {
		if(a == 0 && b == 0 && c == 0) return 0;
		if(dp[a][b][c] != 0) return dp[a][b][c];
		int result = Integer.MAX_VALUE;
		result = Math.min(result, dfs(Math.max(a - 9 , 0),Math.max(b - 3 , 0),Math.max(c - 1 , 0)) + 1);
		result = Math.min(result, dfs(Math.max(a - 9 , 0),Math.max(b - 1 , 0),Math.max(c - 3 , 0)) + 1);
		result = Math.min(result, dfs(Math.max(a - 3 , 0),Math.max(b - 9 , 0),Math.max(c - 1 , 0)) + 1);
		result = Math.min(result, dfs(Math.max(a - 3 , 0),Math.max(b - 1 , 0),Math.max(c - 9 , 0)) + 1);
		result = Math.min(result, dfs(Math.max(a - 1 , 0),Math.max(b - 3 , 0),Math.max(c - 9 , 0)) + 1);
		result = Math.min(result, dfs(Math.max(a - 1 , 0),Math.max(b - 9 , 0),Math.max(c - 3 , 0)) + 1);
//		System.out.printf("%d %d %d %d\n",a,b,c,result);
		dp[a][b][c] = result;
		return result;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		dp = new int[61][61][61];
		hp = new int[3];
		for(int i = 0 ; i < n ; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dfs(hp[0],hp[1],hp[2]));
	}
}
