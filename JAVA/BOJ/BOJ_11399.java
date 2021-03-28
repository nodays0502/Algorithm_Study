import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
	static int n;
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		int result= 0 ;
		int sum = 0 ;
		for(int i = 0 ; i < n ; i++) {
			sum += input[i];
			result += sum;
		}
		System.out.println(result);
	}
}
