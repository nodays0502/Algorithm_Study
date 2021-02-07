package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class SWea_bracket {
	static String open = "([{<";
	static String end = ")]}>";
	static boolean result = true;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1 ; t <= 10 ; t++) {
			int n =Integer.parseInt(br.readLine());
			String st = br.readLine();
			Stack<Character> s = new Stack<>();
			result = true;
			for(int i = 0 ; i < n ; i++) {
				char now = st.charAt(i);
				if(open.contains(now+"")) {s.push(now);}
				else {
					if(end.indexOf(now) == open.indexOf(s.peek())) {
						s.pop();
					}else {
						result = false;
					}
					
				}

			}
			if(result) result = s.isEmpty();
			if(result)
				System.out.println("#"+t+" 1");
			else
				System.out.println("#"+t+" 0");
		}
	}
}
