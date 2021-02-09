package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String pung = br.readLine();
		Stack<Character> s = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++) {
			s.push(str.charAt(i));
			if(s.size() >= pung.length()) {
				boolean same = true;
				for(int j = 0 ; j < pung.length(); j++) {
					if(s.get(s.size()-pung.length() + j) != pung.charAt(j)) {
						same = false;
						break;
					}
				}
				if(same) {
					for(int j = 0 ; j < pung.length(); j++) {s.pop();}
				}
			}
		}
		
		if(s.size() > 0) {
			StringBuilder result = new StringBuilder();
			while(!s.isEmpty()) {
				result.append(s.pop());
			}
			result = result.reverse();
			System.out.println(result);
		}else {
			System.out.println("FRULA");
		}
	}
}
