package LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1365 {
	static int n;
	static int input[];
	static int LIS[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n];
		LIS = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(LIS, 1);
		int result = 0;
		for(int i = 0 ; i < n ; i++) {
			int temp = Arrays.binarySearch(LIS, 0,result,input[i]);
			temp = Math.abs(temp) - 1;
			if(result == temp) result++;
			
		}
		System.out.println(n-result);
	}
}
