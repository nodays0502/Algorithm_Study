package SsafyPrac;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
	static int N, M;
	static int input[];
	static int result = 0 ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int sp = 0;
		int ep = 0;
		int sum = 0 ;
		while(true) {
			if(sum < M) {
				if(ep >= N )break;
				sum += input[ep++];
			}
			else if(sum == M) {
				result++;
				sum -= input[sp++];
			}else {
				sum -= input[sp++];
			}
			if(sp >= N) break;
		}
		System.out.println(result);
		
	}
}
