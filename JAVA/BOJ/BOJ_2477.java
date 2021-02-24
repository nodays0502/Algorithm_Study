package im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2477 {
	static int n , k ;
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		k = Integer.parseInt(st.nextToken());
		int firstchangedir;
		input = new int[6]; 
		int firstlength ;
		for(int i = 0 ; i < 6 ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			input[i] = length;

		}
		int sum = 0 ;
		int max = 0 ;
		for(int i = 0 ; i < 6; i++) {
			if(i == 0) {
				max = Math.max(max, input[0] * input[5]);
				sum += input[0] * input[5];
				continue;
			}
			max = Math.max(max, input[i] * input[i-1]);
			sum+= input[i]*input[i-1];
		}
		System.out.println(k*(max - (3*max-sum)));
	}
}
