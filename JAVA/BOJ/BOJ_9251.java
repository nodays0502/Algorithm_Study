package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9251 {
	static String input1,input2;
	static int dp[][];
	static int dfs(int a,int b) {
		if(a >= input1.length() || b >= input2.length()) return 0;
		if(dp[a][b] != -1 )return dp[a][b]; 
		int result = 0 ;
		if(input1.charAt(a) == input2.charAt(b)) {
			result++;
			result += dfs(a+1 , b+1);
		}else {
			result = Math.max(dfs(a+1,b), dfs(a,b+1));
		}
		dp[a][b] = result;
		return result;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input1 = br.readLine();
		input2 = br.readLine();
		dp = new int[input1.length()][input2.length()];
		for (int i = 0 ; i < input1.length(); i++) {
			for(int j = 0  ; j < input2.length(); j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
	}
}
