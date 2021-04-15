package Lecture0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_2577 {
	static int N , d , k , c;
	static int result = 0;
	static int num[];
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		 N = Integer.parseInt(st.nextToken()); 
		 d = Integer.parseInt(st.nextToken());
		 k = Integer.parseInt(st.nextToken());
		 c = Integer.parseInt(st.nextToken());
		 
		 num = new int[d+1];
		 input = new int[N + k];
		 int count = 1;
		 int result = 1;
		 for(int i = 0 ; i < N ; i++) {
			 input[i] = Integer.parseInt(br.readLine());
		 }
		 
		 for(int i = 0 ; i < k ; i++) {
			 input[N+i] = input[i]; 
		 }

		 for(int i = 0 ; i < N + k ; i++) {
			 if(num[input[i]] == 0 && input[i] != c) {
				 count++; // 종류를 하나 늘린다.
			 }
			 num[input[i]]++; // 개수 하나 올린다.
			 if(i - k >= 0 ) {
				 num[input[i-k]]--;
				 if(num[input[i-k]] == 0 && input[i-k] != c) 
					 count--; // 종류를 하나 뺴준다.
			 }
			 result = Math.max(result, count);
//			 System.out.println(Arrays.toString(num));
		 }

		 System.out.println(result);
	}

}
