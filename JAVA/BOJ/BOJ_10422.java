import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10422 {
	static int n;
	static long dp[];
	static int input[];
	static final int  LIMIT = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int max = 4;
		input = new int[n];
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(br.readLine());
			max = Math.max(input[i], max);
		}
		dp = new long[max/2+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3 ; i <= max / 2 ; i++) {
			for(int j = i ; j >= 1 ; j--) {
				dp[i] += (dp[i-j]*dp[j-1])%LIMIT;
				dp[i] %= LIMIT;
			}
		}
	//	System.out.println(Arrays.toString(dp));
		for(int i = 0 ; i < n ; i++) {
			if(input[i] % 2 !=0)
				System.out.println(0);
			else
				System.out.println(dp[input[i]/2]);
		}
	}
}
