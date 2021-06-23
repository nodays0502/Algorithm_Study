package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
	static int n;
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		int sum = 0;
		int result = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine()," ");
		input = new int[n];
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken()); 
			sum += input[i];
			if(sum < 0) {
				sum = 0 ;
			}
			result = Math.max(result, sum);
		}
		System.out.println(result);
	}
}
