import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
public class BOJ_13706 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String N = st.nextToken();
		BigInteger num = new BigInteger(N);
/*		BigInteger i = new BigInteger("1");
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		while(num.compareTo(i) != 0) {
//			System.out.println(i);
			BigInteger temp = new BigInteger(i.toString());
			temp = temp.multiply(temp);
			if(temp.compareTo(num) == 0) { break;}
			i = i.add(one);
		}*/
		BigInteger result = num.sqrt();
		System.out.println(result);
	}
}
