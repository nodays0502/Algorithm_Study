package LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14002 {
	static int n ; 
	static int input[];
	static int dp[];
	static int preIndex[];
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n];
		dp = new int[n];
		preIndex = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			preIndex[i] = -1;
		}
		int result = 1;
		int resultIndex = 0;
		for(int i = 1 ; i < n ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(input[j] < input[i] && dp[j]+1 > dp[i]) {
					dp[i] = dp[j]+1;
					preIndex[i] = j;
				}
			}
			if(result < dp[i]) {
				result = dp[i];
				resultIndex = i;
			}
		}
//		System.out.println(Arrays.toString(preIndex));
		System.out.println(result);
		List<Integer> list = new ArrayList<>();
		for(int i = resultIndex ; i >= 0 ; i = preIndex[i]) {
			list.add(input[i]);
		}
		for(int i = result-1 ; i >= 0 ; i--) {
			System.out.print(list.get(i)+" ");
		}
	}
}
