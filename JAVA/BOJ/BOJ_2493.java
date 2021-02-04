import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
	static int num[];
	static int result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		num = new int[n];
		result = new int[n];
		for(int i = 0 ; i < n ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		//		queue.offer(new int[] {person,1});
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {n-1 , num[n-1]});
		for(int i = n-2 ; i >= 0 ; i--) {
			/*if(stack.isEmpty()) {
				stack.push(new int[] {i,num[i]});		
			}
			else if(stack.peek()[1] < num[i]) {
					int[] temp = stack.pop();
					result[temp[0]] = i+1; 		
			}*/
			if(stack.isEmpty()) {
				stack.push(new int[] {i,num[i]});		
			}else {
				while(!stack.isEmpty() && stack.peek()[1] <= num[i]) {
					int[] temp = stack.pop();
					result[temp[0]] = i+1; 	
				}	
			}
			stack.push(new int[] {i,num[i]});			

		}
		stack.clear();
		for(int i = 0 ; i < n ; i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}

}
