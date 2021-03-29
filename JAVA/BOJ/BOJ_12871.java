import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12871 {
	static String makeSmall(String str) {
		String result = str;
		for(int t = 1 ; t <= str.length(); t++) {
			String temp = str.substring(0,t);
			int size = temp.length();
			for (int i = 0 , j = 0; i < str.length(); i++, j++) {
				if(j == size) j = 0;
//				System.out.println(i+" "+str.charAt(i)+" "+temp.charAt(j));
				if (str.charAt(i) == temp.charAt(j)) {
					if (i == str.length() - 1 && j == size-1) {
//						System.out.println(temp);
						return temp;
					}
				} else {
					break;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
//		System.out.println(makeSmall(s));
//		System.out.println(makeSmall(t));
		if(makeSmall(s).equals(makeSmall(t))) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
