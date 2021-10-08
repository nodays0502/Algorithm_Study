import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n;
        answer -= lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        Set<Integer> same = new HashSet<>();
        Set<Integer> s = new HashSet<>();
        for(int i = 0 ; i < lost.length ; i++){
            s.add(lost[i]);
        }
        for(int i = 0 ; i < reserve.length ; i++){
            if(s.contains(reserve[i])){
                same.add(reserve[i]);
                answer++;
            }
        }
        int li = 0;
        for(int i = 0 ; i < reserve.length ; i++){
            while(li < lost.length && same.contains(lost[li])){
                li++;
            }
            while(i < reserve.length && same.contains(reserve[i])){
                i++;
            }
            if(i >= reserve.length) break;
            if(li >= lost.length) break;
            int num = reserve[i];
            if(Math.abs(lost[li] - num) <= 1){
                li++;
                answer++;
            }else if(lost[li] < num){
                while(lost[li] < num -1){
                    li++;
                    if(li >= lost.length) break;
                }
                i--;
            }
        }
        return answer;
    }
}
