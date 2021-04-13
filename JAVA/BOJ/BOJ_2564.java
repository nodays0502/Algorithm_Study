package Lecture0413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Node{
	int type;
	int length;
	public Node(int type, int length) {
		super();
		this.type = type;
		this.length = length;
	}
	@Override
	public String toString() {
		return "Node [type=" + type + ", length=" + length + "]";
	}
	
}
public class BOJ_2564 {
	static int n , m ,k;
	static Node input[];
	static Node security;
	static int cal() {
		int result = 0 ;
		for(int i = 0 ; i < k  ; i++) {
//			System.out.println(result);
			if(security.type == input[i].type) {
				result += Math.abs(security.length - input[i].length);
//				System.out.println("a");
			}
			else if(security.type / 3  ==  input[i].type / 3) {
				int sum = security.length + input[i].length;
				if(security.type /3 == 0) {
					result += n;
					result += Math.min(sum, 2*m-sum);
				}else {
					result += m;
					result += Math.min(sum, 2*n-sum);
				}
//				System.out.println("b");
			}else {
				int[] sPot = changePoint(security.type,security.length);
				int[] iPot = changePoint(input[i].type,input[i].length);
				result += (Math.abs(sPot[0]-iPot[0]) + Math.abs(sPot[1]-iPot[1]));
//				System.out.println("c");
			}
//			security = input[i];
		}
		return result;
	}
	static int[] changePoint(int type , int length) {
		int y = 0;
		int x = 0;
		if(type == 1) {
			y = n;
			x = length;
		}else if(type == 2) {
			x = length;
		}else if(type ==3 ) {
			y = n - length;
		}else if(type ==4) {
			y = n -length;
			x = m;
		}
		return new int[] {y,x};
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		k  = Integer.parseInt(st.nextToken());
		input = new Node[k];
		for(int i = 0 ; i < k+1 ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int type= Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			if(i != k)
				input[i] = new Node(type,length);
			else
				security = new Node(type,length);
		}
		System.out.println(cal());
	}
}// 문제 똑바로 안 읽나
