package im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_1859 {
	static int n;
	static int input[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SWea_1859_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			input = new int[n];
			st = new StringTokenizer(br.readLine()," "); 
			for(int i = 0 ; i < n ; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			long sum = 0 ;
			int max = input[n-1];
			for(int i = n-2 ; i >= 0 ; i--) {
				if(input[i] >= max) {max = input[i]; continue;}
				sum += max - input[i];
			}
			System.out.println("#"+t+" "+sum);
		}
	}

}
