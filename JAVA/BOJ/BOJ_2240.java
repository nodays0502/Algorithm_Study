package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2240 {
	static int T , W;
	static int input[];
	static int dp[][][];
	static int answer = 0;
	static int dfs(int depth, int w, int now) {
		if(depth == -1) {
			int result = 0 ;
			if(w < W)
				result = Math.max(result, dfs(depth+1,w+1,(now+1) % 2));
			result = Math.max(result, dfs(depth+1,w,now));
			return result;
		}
		else if(T == depth) {
			return 0;
		}else {
			int result = 0 ;
			if(dp[depth][w][now] != 0) return dp[depth][w][now];
			if(w < W)
				result = Math.max(result, dfs(depth+1 , w+1 , (now+1) % 2));
			result = Math.max(result,dfs(depth+1 , w ,now));
			if(input[depth] == now)
				result++;
			dp[depth][w][now] = result;
			answer = Math.max(answer, result);
			return result;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		input = new int[T];
		dp = new int[T][W+2][2];
		for(int i = 0 ; i < T ; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			input[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		dfs(-1,0,0);
		System.out.println(answer);
	}

}
