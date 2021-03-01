package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4779 {
	static String n;
	static String dp[] = new String[13];
	static String cal(int now) {
		if(dp[now] != null) return dp[now];
		else {
			StringBuilder sb = new StringBuilder();
			sb.append(cal(now-1)); 
			for(int i = 0 ; i < (int)Math.pow(3,now-1); i++) {
				sb.append(" ");
			}
			sb.append(cal(now-1)); 
			dp[now] = sb.toString();
			return dp[now];
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = br.readLine();
		dp[0] = "-";
		while(n != null) {
			System.out.println(cal(Integer.parseInt(n)));
			n = br.readLine();
		}
	}
}