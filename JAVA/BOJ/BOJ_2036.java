package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2036 {
	static int n;
	static long plus[];
	static long minus[];
	static int plusCnt;
	static int minusCnt;
	static boolean findZero = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		plus = new long[n];
		minus = new long[n];
		for(int i = 0 ; i < n ; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > 0 ) {
				plus[plusCnt++] = temp;
			}else if(temp < 0){
				minus[minusCnt++] = temp;
			}else {
				findZero = true;
			}
		}
		plus = Arrays.copyOf(plus, plusCnt);
		minus = Arrays.copyOf(minus, minusCnt);
		Arrays.sort(plus);
		Arrays.sort(minus);
		long result = 0 ;
		for(int i =  plusCnt-1 ; i > 0 ; i-=2) {
			if(plus[i-1] == 1 || plus[i] == 1 ) {result += (plus[i-1] +plus[i]);}
			else {
				long temp = plus[i] * plus[i-1];
				result += temp;
			}
		}
		if(plusCnt % 2  != 0 ) result += plus[0];
		for(int i =  0 ; i < minusCnt-1 ; i+=2) {
			long temp = minus[i] * minus[i+1];
			result += temp;
		}
		if(findZero && minusCnt % 2  != 0) ;	
		else if(minusCnt % 2  != 0 ) result += minus[minusCnt -1];	
		System.out.println(result);
	}

}
