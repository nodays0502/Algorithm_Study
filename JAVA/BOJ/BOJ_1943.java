package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1943 {
	static int n ;
	static int input[][];
	static int result;
	static int dp[][];
	static boolean flag;
	static int cal(int depth,int sum) {
		if(flag)  return 0;
		if(sum > result/2) return 0;
		else if(sum == result/2) return 1;
		if(depth == n) {
			if(sum == result/2) {flag = true; return 1;}
			else return 0;
		}else {
			if(dp[depth][sum] != -1) return dp[depth][sum];
			int check = 0;
			for(int i = 0 ; i <= input[depth][1] ; i++) {
				check += cal(depth + 1 , sum + input[depth][0] * i);
				if(check > 0) break;
			}
			if(check >0) dp[depth][sum] = 1;
			else dp[depth][sum] = 0;
			return check;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		Scanner sc = new Scanner(System.in);
		for(int t = 0 ; t < 3; t++) {
//			n = sc.nextInt();
			st= new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			input = new int[n][2];
			result = 0;
			dp = new int[n][100001]; // 100,000
			flag = false;
			for(int i = 0 ; i < n ; i++) {
				st= new StringTokenizer(br.readLine()," ");
				Arrays.fill(dp[i], -1);
//				input[i][0]= sc.nextInt();
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
//				input[i][1]= sc.nextInt();
				result += input[i][0] * input[i][1];
			}
			if(result %2 != 0) {
				System.out.println(0);
				return ;
			}
			if(cal(0,0) > 0) 
				System.out.println(1);
			else
				System.out.println(0);
			
		}
	}
}
