import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12907 {
	static int n;
	static int count[] = new int[41];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < n ; i++) {
			int temp = Integer.parseInt(st.nextToken());
			count[temp]++;
		}
	//	System.out.println(Arrays.toString(count));
		int sum = 0;
		int result = 1;
		boolean findOne = false;
		for(int i = 0 ; i < n ; i++) {
			if(count[i] == 2) {
				if(!findOne) result *= 2;
				else break;
			}else if(count[i] == 1) {
				findOne = true;
			}else {
				break;
			}
			sum+=count[i];
		}
		if(findOne) result *= 2;
		if(sum != n) result = 0;
		System.out.println(result);
	}
}
