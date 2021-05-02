package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2846 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int[] input = new int[n];
		int prev = 0;
		int result = 0;
		int min = 0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(i == 0) {
				min = temp;
			}else {
				if(prev >= temp) {
	//				System.out.println(prev+" " +min+" "+result);
					result = Math.max(result, prev - min);
					min = temp;
				}
			}
			if(i == n-1) {
				result = Math.max(result, temp - min);
			}
			prev = temp;
		}
		System.out.println(result);
	}

}
