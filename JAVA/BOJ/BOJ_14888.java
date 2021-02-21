package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	static int n;
	static int input[];
	static int operator[];
	static boolean use[][]; // + , - , * , /
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static public void perm(int cnt,int result) {
		if(cnt == n-1) {
			max = Math.max(result, max);
			min = Math.min(result, min);
		}else {
			for(int i = 0 ; i < 4; i++) {
				if(operator[i] > 0) {
					operator[i]--;
					if(cnt == 0) {
						switch(i) {
						case 0: perm(cnt + 1 , input[0] + input[1]);break;
						case 1: perm(cnt + 1 , input[0] - input[1]);break;
						case 2: perm(cnt + 1 , input[0] * input[1]);break;
						case 3: perm(cnt + 1 , input[0] / input[1]);break;
						}
					}
					else{
						switch(i) {
						case 0: perm(cnt + 1 , result + input[cnt+1]);break;
						case 1: perm(cnt + 1 , result - input[cnt+1]);break;
						case 2: perm(cnt + 1 , result * input[cnt+1]);break;
						case 3: perm(cnt + 1 , result / input[cnt+1]);break;
						}
					}
					operator[i]++;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		input = new int[n];
		operator = new int[4];
		for(int i = 0 ; i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < 4 ; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		perm(0,0);
		System.out.printf("%d\n%d",max,min);
	}
}
