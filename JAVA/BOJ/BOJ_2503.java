import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2503 {
//	static final int LIMIT = (9*8*7);
	static int n;
	static boolean[] isSelected = new boolean[10];
	static StringBuilder sb = new StringBuilder();
	static String[] command ;
	static int[] b;
	static int[] s;
	static int[] choice = new int[3];
	static int result = 0;
	static void prem(int cnt) { // 기본 순열 코드
		if(cnt == 3) {
			for(int i : choice)
				sb.append(i); // "123"만들 때 "1" , "2", "12" , "3" 안 만들기위해
			check(sb.toString());
			sb.setLength(0); // ""으로 초기화
		}else {
			for(int i = 1 ; i <= 9 ; i++ ) {
				if(!isSelected[i]){
					isSelected[i] = true;
					choice[cnt] = i;
					prem(cnt+1);
					isSelected[i] = false;
				}
			}
		}
	}
	static void check(String now) { // 모든 명령어와 비교
		int ns,nb;
		for(int i = 0 ; i < n; i++) {
			ns = 0;
			nb = 0;
			for(int j = 0 ; j < 3 ; j++) { // command[j]
				for(int k = 0;k < 3;k++) { // now[k]
					if(command[i].charAt(j) == now.charAt(k)) {
						if(j == k ) {ns++;}
						else {nb++;}
					}
				}
			}
			if(ns != s[i] || nb != b[i]) {return;}
		}
		result++;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		command = new String[n];
		s = new int[n];
		b = new int[n];
		for(int i = 0 ; i < n ; i++) // 입력 받는 코드   ,  명령어를 받는 배열생성
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			command[i] = st.nextToken();
			s[i] = Integer.parseInt(st.nextToken()); 
			b[i] = Integer.parseInt(st.nextToken());			
		}
		prem(0);
		System.out.println(result);
	}
}
