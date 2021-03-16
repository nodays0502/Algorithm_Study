package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	static int L , C;
	static char input[];
	static char choose[];
	static String vowel = "aeiou";
	static int check[] = new int[2];
	static StringBuilder sb = new StringBuilder();
	static void comb(int depth , int start) {
		if(depth == L) {
			if(check[0] >=1 && check[1] >=2)
				sb.append(new String(choose)+"\n");
		//		System.out.println(choose);
		}else {
			for(int i = start ; i < C ; i++) {
				choose[depth] = input[i];
				if(vowel.contains(input[i]+"")) {
					check[0]++;
					comb(depth+1,i+1);
					check[0]--;
				}else {
					check[1]++;
					comb(depth+1,i+1);
					check[1]--;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		choose = new char[L];
		comb(0,0);
		System.out.println(sb);
	}
}
