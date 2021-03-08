package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2785 {
	static int n;
	static int input[];
	static int result = Integer.MAX_VALUE ;
	static int cal(int minIndex , int restlength) {
//		System.out.println(minIndex +" "+restlength+" "+input[minIndex]);
		if(input[minIndex] == restlength - 1) {return input[minIndex];} // 현재 체인이 빠지는 것
		else if(input[minIndex] > restlength - 1) {
			return restlength;
		}else
			return cal(minIndex+1 , restlength - input[minIndex]-1) + input[minIndex];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		input = new int[n];
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		System.out.println(cal(0,n-1));;
	}
}
