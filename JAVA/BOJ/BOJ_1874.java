package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;

public class BOJ_1874 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        Deque<Integer> stack = new LinkedList<>();
        int n = stoi.apply(br.readLine());
        int num = 1;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            int now = stoi.apply(br.readLine());
            while(stack.isEmpty() || stack.peek() < now){
                stack.push(num++);
                sb.append("+\n");
            }
            if (!stack.isEmpty() && stack.peek() == now){
                stack.pop();
                sb.append("-\n");
            }else{
                flag = false;
            }
//            System.out.println(flag);
        }
        if(!flag){
            System.out.println("NO");
        }else{
            System.out.println(sb.toString());
        }
    }
}
