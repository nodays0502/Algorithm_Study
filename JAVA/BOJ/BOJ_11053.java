package LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
	static int n ; 
	static int input[];
	static int dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n];
		dp = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		int result = 1;
		for(int i = 1 ; i < n ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(input[j] < input[i] && dp[j]+1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
