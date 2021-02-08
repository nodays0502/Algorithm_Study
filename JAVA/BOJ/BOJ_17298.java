package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
	static int n;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		Stack<int[]> s= new Stack<>(); // 인덱스 , 값
		result = new int[n];
		for(int i = 0 ; i < n ; i++) {
			result[i] = -1;
			int num = Integer.parseInt(st.nextToken());
			if(s.isEmpty() || s.peek()[1] >= num){ // 보다 크다고 했으니 초과개념
				s.push(new int[] {i , num});
			}else { // s.peek()[1] <= num
				while(!s.isEmpty() && s.peek()[1] < num ) {
					result[s.pop()[0]] = num;
				}
				s.push(new int[] {i,num});
			}
		}
		for(int i = 0 ; i < n ; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
	}

}
