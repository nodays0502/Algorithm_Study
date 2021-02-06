import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
class Person {
	int kg;
	int cm;
	Person(int kg , int cm){
		this.kg = kg;
		this.cm = cm;
	}
}
public class BOJ_7568 {
	static int n ; 
	static int[][] input; // kg , cm
	static int[] result ;

	/*static void check(int now) {
//		if(result[now] != 0) {return ;}
		int ranking = 1;
	//	List<Integer> list = new LinkedList<Integer>();
		for(int i = 0 ; i < n ; i++) {
			if(input[now][0] > input[i][0] && input[now][1] > input[i][1]) { // now가 i보다 덩치가 크다.
				
			}else if(input[now][0] >= input[i][0] || input[now][1] >= input[i][1]) { // 비교할 수 없다. // 자기자신도 포함
	//			list.add(i);
			}else {
				ranking++; 
			}
		}
//		result[now] = ranking;
		for(int i = 0 ; i < list.size(); i++) {
	//		result[list.get(i)] = Math.min(ranking,result[list.get(i)]);
		}
		list.clear();
	}*/
	static void check(int now) {
		for(int i = 0 ; i < n ; i++) {
			if(input[now][0] > input[i][0] && input[now][1] > input[i][1]) { // now가 i보다 덩치가 크다.
				result[now]--;
			}else if(input[now][0] >= input[i][0] || input[now][1] >= input[i][1]) { // 비교할 수 없다. // 자기자신도 포함
				result[now]--;
			}else {
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		input = new int[n][2];
		result = new int[n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			input[i][0] = Integer.parseInt(st.nextToken()); 
			input[i][1] = Integer.parseInt(st.nextToken()); 
			result[i] = n+1;
		}
		for(int i = 0  ; i < n ; i++ ) {
			check(i);
		}
//		System.out.println(Arrays.deepToString(input));
//		System.out.println(Arrays.toString(result));
		for(int i = 0 ; i < n ; i++) {
			System.out.print(result[i] + " ");	
		}

	}
}
