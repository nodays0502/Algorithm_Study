package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_10828 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if("push".equals(command)){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }else if("pop".equals(command)){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.pop());
                }
            }else if("top".equals(command)){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }else if("size".equals(command)){
                System.out.println(stack.size());
            }else if("empty".equals(command)){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
