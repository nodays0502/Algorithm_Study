package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
	static int n;
	static int input[][];
	static int result = Integer.MAX_VALUE;
	static boolean isSelected[];
	static void comb(int cnt,int start) {
		if(cnt == n/2) {
			int[] sum = new int[2];
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(i == j ) continue;
					if(isSelected[i] && isSelected[j]) {
						sum[0] += input[i][j];
					}
					if(!isSelected[i] && !isSelected[j]) {
						sum[1] += input[i][j];
					}
				}
			}
			result = Math.min(result, Math.abs(sum[0] - sum[1]));
		}else {
			for(int i = start ; i < n; i++) {
				if(!isSelected[i]) {
					isSelected[i] = true;
					comb(cnt+1, i);
					isSelected[i] = false;
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n][n];
		isSelected = new boolean[n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < n ; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		System.out.println(result);
	}

}
