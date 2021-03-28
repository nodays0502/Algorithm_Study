import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12026 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] input = new char[n];
		int[] dp = new int[n];
		String command = br.readLine();
		for(int i = 0 ; i < n ; i++) {
			input[i] = command.charAt(i);
			dp[i] = -1;
		}
		dp[0] = 0;
		for(int i = 0 ; i < n ; i++) {
			int now = dp[i];
			for(int j = i+1 ; j < n ; j++) {
				if(dp[i] == -1) break;
				if(input[i] == 'B' && input[j] == 'O') {
					int k = i - j;
					if(dp[j] == -1)
						dp[j] = now + k * k;
					else
						dp[j] = Math.min(dp[j],now + k * k);
				}else if(input[i] == 'O'&& input[j] == 'J') {
					int k = i - j;
					if(dp[j] == -1)
						dp[j] =now + k * k;
					else
						dp[j] = Math.min(dp[j], now + k * k);
				}else if(input[i] == 'J'&& input[j] == 'B') {
					int k = i - j;
					if(dp[j] == -1)
						dp[j] = now + k * k;
					else
						dp[j] = Math.min(dp[j], now + k * k);
				}
			}
		}
		System.out.println(dp[n-1]);
	}
}
