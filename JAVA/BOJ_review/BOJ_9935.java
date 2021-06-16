package KMP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String check = br.readLine();
		Stack<Character> s = new Stack<>();
		for(int i = 0 ; i < input.length(); i++) {
			s.push(input.charAt(i));
			if(s.size() >= check.length()) {
				boolean same = true;
				for(int j = 0 ; j < check.length(); j++) {
					if(s.get(s.size() - check.length() + j) != check.charAt(j)) {
						same = false;
						break;
					}
				}
				if(same) {
					for(int j = 0 ; j < check.length(); j++) s.pop();
				}
			}
		}
		
		if(s.size() == 0) {
			System.out.println("FRULA");
			return;
		}
		StringBuilder sb = new StringBuilder();
		while(s.size() > 0) {
			sb.append(s.pop());
		}
		System.out.println(sb.reverse());
	}
}
