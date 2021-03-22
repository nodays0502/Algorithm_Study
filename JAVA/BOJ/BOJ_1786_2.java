package KMP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1786_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		int TLength = T.length(), PLength = P.length();
		int fail[] = new int[PLength];
		for(int i = 1, j = 0; i < PLength; i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) {
				j = fail[j-1];
			}
			if(P.charAt(i) == P.charAt(j)) {
				fail[i] = ++j;
			}
		}
	//	System.out.println(Arrays.toString(fail));
		int cnt = 0 ;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0 , j = 0 ; i < TLength ; i++) {
			while(j > 0 && T.charAt(i) != P.charAt(j)) {
				j = fail[j-1];
			}
			if(T.charAt(i) == P.charAt(j)) {
				if(j == PLength-1) {
					cnt++;
					list.add((i+1) - PLength + 1);
					j = fail[j];
				}else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		if(cnt > 0) {
			for(int i = 0 ; i < list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
		}
	}
}
