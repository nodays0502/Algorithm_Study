import java.util.*;
class Solution {
    static List<Integer> map[];
    static Map<Integer,Integer> seq = new HashMap<>();
    static Map<Integer,Integer> rseq = new HashMap<>();
    static int visited[]; // 0 방문 X , 1 방문 , 2 대기
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        if(!rseq.containsKey(0)){
            q.offer(0);
        }
        while(!q.isEmpty()){
            int now = q.poll();
            visited[now] = 1;
            Integer unlock = seq.get(now);
            if(unlock != null && visited[unlock] == 2){
                q.offer(unlock);
            }
            // System.out.println(now);
            for(int i = 0 ; i < map[now].size() ; i++){
                int next = map[now].get(i);
                if(visited[next] != 1){
                    if(!rseq.containsKey(next) || visited[next] == 2){
                        q.offer(next);
                    }else{
                        int check = rseq.get(next);
                        // System.out.println("check"+check+" "+next);
                        if( visited[check] == 1){
                            q.offer(next);
                        }else{
                            visited[next] = 2;
                        }
                    }
                }
            }
        }
    }
    public boolean solution(int n, int[][] path, int[][] orders) {
        boolean answer = true;
        map = new ArrayList[n];
        visited = new int[n];
        for(int i = 0 ; i < n ; i++){
           map[i] = new ArrayList<>(); 
        }
        for(int[] connect : path){
            map[connect[0]].add(connect[1]);
            map[connect[1]].add(connect[0]);
        }
        for(int[] order : orders){
            int a = order[0];
            int b = order[1];
            seq.put(a,b);
            rseq.put(b,a);
        }
        bfs();
        for(int i = 0 ; i < n ; i++){
            // System.out.println(visited[i]);
            if(visited[i] != 1){
                answer = false;
                break;
            }
        }
        return answer;
    }
}
