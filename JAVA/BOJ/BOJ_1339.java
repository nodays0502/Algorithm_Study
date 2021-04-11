package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1339 {
	static int n;
	static int num = 9;
	static int[] alpha = new int[26];
	static int count[][] = new int[8][26];
	static int now;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String command = st.nextToken();
			int size = command.length();
			for(int j = 0 ; j < size ; j++) {
				count[8-size+j][command.charAt(j)-'A']++;
			}
		}
		int result = 0;
		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0 ; j < 26 ; j++) {
				alpha[j] *= 10;
				alpha[j] += count[i][j];
			}
		}
		Arrays.sort(alpha);
		int num = 9;		
		for(int i = 26-1 ; i >= 0 ; i--) {
			if(alpha[i] == 0)continue;
			result += alpha[i]*num--;
		}
		System.out.println(result);
	}
}
