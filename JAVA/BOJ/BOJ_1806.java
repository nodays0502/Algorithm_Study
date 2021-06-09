package partsum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
	static int N,S;
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		input = new int[N];
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int si = 0;
		int ei = 0;
		int sum = 0;
		int result = 100001;
		while(true) {
		//	System.out.println(ei);
			if(sum < S) {
				if(ei >= N) {
					break;
				}
				sum += input[ei];
				ei++;
			}else {
				result = Math.min(result, ei - si);
				sum -= input[si];
				si++;
			}

		}
		if(result == 100001) {
			result = 0 ;
		}
		System.out.println(result);
	}
}
