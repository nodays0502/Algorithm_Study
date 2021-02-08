package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_13458 {
	static int n ;
	static int A[];
	static int B , C;
	static long result ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		A = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		B= Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		result = n;
		for(int i = 0 ; i < n ; i++) {
			A[i] -= B;
		}
		for(int i = 0 ; i < n ; i++) {
			if(A[i] % C == 0) result += A[i]/C; 
			else result += A[i]/C+1; 
		}
		System.out.println(result);
	}

}
