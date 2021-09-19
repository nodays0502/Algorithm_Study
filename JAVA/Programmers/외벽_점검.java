import java.util.*;
class Solution {
    static int result = 987654321;
    static int visited[];
    static int size;
    static void dfs(int depth , int[] weak , int[] dist){
        if(depth == dist.length){
            return ;
        }else{
            // System.out.println(Arrays.toString(visited));
            for(int i = 0 ; i < weak.length; i++){
                if(visited[i] == 0){
                    int length = dist[depth];
                    clean(i,true,length,weak);
                    if(check(weak.length)){
                        // System.out.println("result:"+Arrays.toString(visited)+" depth:"+depth);
                        result = Math.min(depth+1,result);
                    }else{
                        dfs(depth+1,weak,dist);
                    }
                    clean(i,false,length,weak);
                }
            }
        }
    }
    static void clean(int index, boolean flag, int length,int[] weak){
        int temp = weak[index] + length;
        for(int i = 0 ; i < weak.length; i++){
            if(weak[i] >= weak[index] && weak[i] <= temp){
                if(flag){
                    visited[i]++;
                }else{
                    visited[i]--;
                }
            }
        }
        if(temp >= size){
            temp -= size;
            for(int i = 0 ; i < weak.length; i++){
                if(weak[i] >= 0 && weak[i] <= temp){
                    if(flag){
                        visited[i]++;
                    }else{
                        visited[i]--;
                    }
                }
            }
        }
    }
    static boolean check(int length){
        for(int i = 0 ; i < length ; i++){
            if(visited[i] == 0)
                return false;
        }
        return true;
    }
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        size = n;
        visited = new int [weak.length];
        Arrays.sort(dist);
        for(int i = 0; i < dist.length/2 ; i++){
            int temp = dist[i];
            dist[i] = dist[dist.length -1 - i];
            dist[dist.length -1 - i] = temp;
        }
        // System.out.println(Arrays.toString(dist));
        dfs(0, weak , dist);
        answer = result;
        if(answer == 987654321){
            answer= -1;
        } 
        return answer;
    }
}
