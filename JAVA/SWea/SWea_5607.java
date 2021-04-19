package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWea_5607 {
	static long cache[] = new long[1000001];
	static final long LIMIT = 1234567891;
	static int n ,r;
	static long power(long x , long y , long p) {
		long res = 1L;
		x = x % p;
		while(y > 0) {
			if(y % 2 == 1) 
				res = (res * x) %p;
			y = y >>1;
			x = (x*x) % p;
			
		}
		return res;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		cache[1] = 1;
		for(int i = 2 ; i <= 1000000;i++) {
			cache[i] = (i*cache[i-1])%LIMIT;
		}
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			System.out.printf("#%d %d\n", t , (cache[n] * power(cache[r],LIMIT-2,LIMIT) % LIMIT
					* power(cache[n-r],LIMIT-2,LIMIT) % LIMIT) % LIMIT);
		}
	}
}
