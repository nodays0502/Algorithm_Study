package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11054 {
	static int n;
	static int input[];
	static int upDp[];
	static int downDp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n];
		upDp = new int[n];
		downDp = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			upDp[i] = 1;
			downDp[i] = 1;
		}
		for(int i = 0 ; i < n ; i++) {
			for(int j = i+1 ; j < n ; j++) {
				if(input[i] < input[j])
				upDp[j] = Math.max(upDp[i] + 1 , upDp[j] );
			}
		}
		for(int i = n-1 ; i >= 0 ; i--) {
			for(int j = i-1 ; j >= 0 ; j--) {
				if(input[i] < input[j])
				downDp[j] = Math.max(downDp[i] + 1 , downDp[j] );
			}
		}
		int result = 0 ;
		for(int i = 0 ; i < n ; i++) {
			int sum = upDp[i] + downDp[i];
			result = Math.max(result, sum-1);
		}
		System.out.println(Arrays.toString(upDp));
		System.out.println(Arrays.toString(downDp));
		System.out.println(result);
	}

}
