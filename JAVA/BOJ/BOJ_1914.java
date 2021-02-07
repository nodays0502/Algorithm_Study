import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1914 {
	static int n ;
	static StringBuilder sb = new StringBuilder();
//	
	static long hanoi(int cnt , int from, int temp , int to) {
		if (cnt == n) {
			return 0;
		} else {
			long result = 1;
			result += hanoi(cnt + 1, from, to, temp);

			sb.append(from + " " + to + "\n");
			result += hanoi(cnt + 1, temp, from, to);
			return result;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		if(n<=20) {
			System.out.println(hanoi(0,1,2,3));
			System.out.println(sb);			
		}else {
			BigInteger result = new BigInteger("1");
			for(int i = 0 ; i < n ; i++){
				result = result.multiply(new BigInteger("2"));
			}
				result = result.subtract(new BigInteger("1"));
				System.out.println(result);
		}
	}
}
