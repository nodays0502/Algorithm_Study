import java.util.*;
class Node{
    int prev;
    int now;
    int next;
    
    public Node(int prev ,int now, int next){
        this.prev = prev;
        this.now = now;
        this.next = next;
    }
}
class Solution {
    static int prev[];
    static int next[];
    static boolean check[];
    static void init (int n){
        for(int i = 0 ; i < n ; i++){
            prev[i] = i-1;
            next[i] = i+1;
            check[i] = true;
        }
        next[n-1] = -1;
    }
    static String cal(int n,int now,String[] cmds){
        Stack<Node> s = new Stack<Node>();
        for(String cmd : cmds){
            // System.out.println(Arrays.toString(check));
            // System.out.println(cmd);
            String[] split = cmd.split(" ");
            if("U".equals(split[0])){
                int num = Integer.parseInt(split[1]);
                while(num > 0){
                    now = prev[now];
                    num--;
                }
            }else if("D".equals(split[0])){
                int num = Integer.parseInt(split[1]);
                while(num > 0){
                    now = next[now];
                    num--;
                }
            }else if("C".equals(split[0])){
                s.push(new Node(prev[now], now, next[now]));
                if(prev[now] != -1){
                    next[prev[now]] = next[now];
                }
                if(next[now] != -1){
                    prev[next[now]] = prev[now];
                }
                check[now] = false;
                if(next[now] != -1) {now = next[now];}
                else {now = prev[now];}
            }else{ // Z
                Node node = s.pop();
                if(node.prev != -1){next[node.prev] = node.now;}
                if(node.next != -1){prev[node.next] = node.now;}
                check[node.now] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            if(check[i]){
                sb.append("O");
            }
            else{
                sb.append("X");
            }
        }
        return sb.toString();
    }
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        prev = new int[n];
        next = new int[n];
        check = new boolean[n];
        init(n);
        answer= cal(n,k,cmd);
        return answer;
    }
}
