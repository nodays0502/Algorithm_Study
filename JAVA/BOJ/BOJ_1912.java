package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int[] input = new int[n];
		int[] dp = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int result = -10000;
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			sum += input[i];
			dp[i] = sum;
			result = Math.max(result, sum);
			if(sum < 0) sum = 0;
		}
		System.out.println(result);
	}
}
