package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_11055 {
	static int n;
	static int input[];
	static int dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " " );
		input = new int[n];
		dp = new int[n];
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = input[i];
		}
		int result = input[0];
		for(int i = 0; i < n  ; i++) {
			for(int j = i+1 ; j < n ; j++) {
				if(input[i] < input[j]) {
					dp[j] = Math.max(dp[j] , dp[i] + input[j]);
					result = Math.max(result,dp[j]);
				}
			}
		}
		System.out.println(result);
	}
}
