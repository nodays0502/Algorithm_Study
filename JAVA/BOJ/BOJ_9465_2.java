package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_2 {
	static int n ;
	static int input[][];
	static int dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t=  0 ; t < T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			input = new int[2][n];
			dp = new int[2][n];
			for(int i = 0 ; i < 2 ; i++ ) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j < n ; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = input[i][j];
				}
			}
			int result = 0 ;
			for(int j = 0 ; j < n ; j++) {
				for(int i = 0 ; i < 2 ; i++ ) {
					if(j+1 < n) {
						dp[(i+1)%2][j+1] =Math.max(dp[(i+1)%2][j+1], dp[i][j] + input[(i+1)%2][j+1]) ;
						result= Math.max(result, dp[(i+1)%2][j+1]);
						
					}
					if(j+2 < n) {
						dp[(i+1)%2][j+2] =Math.max(dp[(i+1)%2][j+2], dp[i][j] + input[(i+1)%2][j+2]);  
			//			dp[i][j+2] =Math.max(dp[i][j+2], dp[i][j] + input[i][j+2]) ;  						
						result= Math.max(result, dp[(i+1)%2][j+2]);
					}
				}
			}
			for(int i = 0 ; i < 2 ; i++ ) {
				for(int j = 0 ; j < n ; j++) {
					
	//				System.out.print(dp[i][j]+" ");
				}
	//			System.out.println();
			}
			System.out.println(result);
		}
	}
}
