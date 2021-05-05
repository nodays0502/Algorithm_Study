package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1038 {
	static int n;
	static long dp[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		dp = new long[n + 20];
		for(int i = 0 ; i <= 9 ; i++) {
			dp[i] = i;
			if(i >= n) {
				System.out.println(dp[n]);
				return ;
			}
		}
		int now = 9;
		System.out.println(Arrays.toString(dp));
		for(int i = 0 ; i <= n ; i++) {
			for(int j = 0 ; j < dp[i] % 10 ; j++) {
				dp[++now] = dp[i]*10 + j;		
	//			System.out.println(now+" " +dp[now]);
				if(now >= n) {
					System.out.println(dp[n]);
					return ;
				}
			}
		}
		System.out.println(-1);
	}
}
