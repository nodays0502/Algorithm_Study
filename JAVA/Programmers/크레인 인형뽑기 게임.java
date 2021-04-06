import java.util.Arrays;
import java.util.Stack;

class Solution {
	static Stack<Integer>[] s;
    static int size = 0 ;
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();
        size = board.length;
        s = new Stack[size];
        for(int i = 0 ; i < size; i++) {
        	s[i] = new Stack<>();
        }
        for(int i = size-1 ; i >= 0 ; i--) {
        	for(int j = 0 ; j < size ; j++) {
  //              System.out.print(board[i][j]+" ");
        		if(board[i][j] != 0) {
        			s[j].push(board[i][j]);
        		}
        	}
 //           System.out.println();
        }
 //       System.out.println(Arrays.toString(s));
        for(int i = 0 ; i < moves.length;i++) {
        	int now = moves[i]-1;
        	if(!s[now].isEmpty()) {
        		int temp = s[now].pop();
 //               System.out.println(i+" "+now+" "+temp);
        		if(result.isEmpty())
        			result.push(temp);
        		else {
        			int top = result.peek();
        			if(top == temp) {
                 //       System.out.println(i);
        				result.pop();
        				answer+=2;
        			}else {
        				result.push(temp);
        			}
        		}
        	}
        }
        return answer;
    }
}
