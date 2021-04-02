import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17103 {
	static int n;
	static int max = 0 ;
	static final int LIMIT = 1000001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	
		boolean number[] = new boolean [LIMIT+1]; // true는 소수가 아니다.
		number[0] = true;
		number[1] = true;
		for(int i = 2 ; i*i <= LIMIT ; i++) {
			if(number[i]) continue;
			for(int j = i*i; j<= LIMIT ; j+=i) {
				number[j] = true;
			}
		}
		for(int i = 0 ; i < n ; i++) {
			int result = 0 ;
			int input = Integer.parseInt(br.readLine());
			for(int j = 0 ; j <= input/2 ; j++) {
				if(number[input/2 -j] == false && number[input/2+j] == false)
					result++;
			}
			System.out.println(result);
		}
	}
}
