package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
	static int n ; 
	static int input[];
	static boolean use[];
	static int choice[];
	static void comb(int depth , int start) {
		if(depth == 6) {
			print();
		}else {
			for(int i = start ; i < n ; i++) {
				if(!use[i]) {
					use[i] = true;
					choice[depth] = input[i];
					comb(depth+1,i+1);
					use[i] = false;
				}
			}
		}
	}
	static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 6 ; i++) {
			sb.append(choice[i]+" ");
		}
		System.out.println(sb);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			input = new int[n];
			use = new boolean[n];
			choice =new int[6];
			for(int i = 0 ; i < n ; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			System.out.println();
		}
	}
}
