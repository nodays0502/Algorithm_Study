package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1082 {
	static int n;
	static int input[];
	static int totalmoney;
	static int count[];
	static BigInteger result = new BigInteger("0");
	static int resultCount = 0 ;
	static int lowPrice = Integer.MAX_VALUE;
	static BigInteger ten = new BigInteger("10");
	static BigInteger zero = new BigInteger("0");
	static void dfs(int depth,int money, int cnt) {
		if(depth < 0) {
		//	System.out.println("asd");
			StringBuilder sb = new StringBuilder();
			int tempCount = 0 ;
			for(int i = n-1 ; i >= 0 ; i--) {
				char nowValue = (char)('0'+i);
		//		System.out.println(nowValue);
				for(int j = count[i]; j > 0 ; j--) {
					sb.append(nowValue);
					tempCount++;
				}
			}
	//		System.out.println(Arrays.toString(count));
	//		System.out.println(result);
			if(sb.length() == 0) return;
			BigInteger now = new BigInteger(sb.toString());
			if(result.compareTo(now) < 0) {
				result = now;
				resultCount = tempCount;
			}
		}else {
			for(int i = money / input[depth] ; i >=0 ; i--) {
				if(resultCount < cnt +i+ (money - i*input[depth]) / lowPrice) {
					count[depth] = i;
					dfs(depth-1,money - i*input[depth],cnt+i);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n];
		count = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ;i < n ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if(input[i] < lowPrice) lowPrice = input[i];
		}
		st = new StringTokenizer(br.readLine()," ");
		totalmoney = Integer.parseInt(st.nextToken());
		dfs(n-1,totalmoney,0);
		System.out.println(result.toString());
	}
}
