package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
	static int N, M;
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		input = new int[N];
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int si = 0;
		int ei = 0;
		int sum = 0;
		int result = 0 ;
		while(true) {
			if(sum < M) {
				if(ei >= N) {
					break;
				}
				sum += input[ei++];
			}else {
				if(sum == M) {
					result++;
				}
				sum -= input[si++];
				if(si >= N) break;
			}
		}
		System.out.println(result);
	}
}
