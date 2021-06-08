package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1065 {
	static boolean cal(int num) {
		boolean flag = true;
		char temp[] = Integer.toString(num).toCharArray();
		for(int i = 0 ; i < temp.length-2; i++) {
			if(temp[i]-temp[i+1] == temp[i+1]-temp[i+2]) {
				;
			}else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0 ;
		for(int i = 1 ; i <= N ; i++) {
			if(cal(i)) result++;
		}
		System.out.println(result);
	}
}
