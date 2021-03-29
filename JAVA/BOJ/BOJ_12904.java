import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904 {
	static String s , t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
		StringBuilder T = new StringBuilder(t);
		StringBuilder S = new StringBuilder(s);
		boolean find = false;
		while(T.length() >= S.length()) {
			int size = T.length();
			if(T.charAt(size-1) == 'A') {
				T.setLength(size-1);
			}else {
				T.setLength(size-1);
				T = T.reverse();
			}
			if(T.length() == S.length() && T.toString().equals(S.toString())) {
				find = true;
			}
		}
		if(find)System.out.println(1);
		else System.out.println(0);
	}
}
