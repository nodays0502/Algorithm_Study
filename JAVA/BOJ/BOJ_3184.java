package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3184 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        Stack<Integer> stack = new Stack<>();
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st= new StringTokenizer(br.readLine()," ");
            int temp = stoi.apply(st.nextToken());
            if(temp == 0){
//                stack.poll();
                stack.pop();
            }else{
//                stack.offer(temp);
                stack.push(temp);
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.println(result);
    }
}
