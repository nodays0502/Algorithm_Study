package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1059 {
	static int n ;
	static int input[];
	static int target;
	static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		input = new int[n];
		for(int i = 0 ;  i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		target = Integer.parseInt(st.nextToken());
		int min = 0;
		int max = 1000 ;
		for(int i = 0 ; i < n ; i++) {
			/*if(input[i-1] < target && input[i] > target) {
				min = Math.max(min, input[i-1]);
				max = Math.min(max, input[i]);
			}*/
			if(input[i] <= target) 
				min = Math.max(min, input[i]);
			if(input[i] > target)
				max = Math.min(max, input[i]);
		}
		System.out.println(min +" "+max);
//		result += (target - input[min]) * (input[min+1] - target) - 1;
		result = (target - min) * (max - target) - 1;
		if(result < 0) result = 0 ;
		System.out.println(result);
//		System.out.println((59-33)*(100-59)-1);
	}
}
