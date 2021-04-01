import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_16922 {
	static int n;
	static long result = 0 ;
	static boolean check[] = new boolean[1001];
	static int[] num = {1,5,10,50};
	static void comb(int depth , int start,int sum) {
		if(depth == n) {
			if(!check[sum]) {
				check[sum] = true;
				result++;
			}
		}else {
			for(int i = start ; i < 4; i++) {
				comb(depth+1,i,sum + num[i]);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		comb(0,0,0);
		System.out.println(result);
	}
}
