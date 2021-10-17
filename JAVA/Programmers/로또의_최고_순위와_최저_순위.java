import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[] {0,0};
        for(int num : win_nums){
            set.add(num);
        }
        int cnt = 0;
        int zeroCnt = 0;
        for(int lotto : lottos){
            if(lotto == 0){
                zeroCnt++;
            }else if(set.contains(lotto)){
                cnt++;
            }
        }
        answer[0] = cal(cnt+zeroCnt);
        answer[1] = cal(cnt);
        return answer;
    }
    private int cal(int cnt){
        int result = 0;
        if(cnt == 6){
            result = 1;
        }else if(cnt == 5){
            result = 2;
        }else if(cnt == 4){
            result = 3;
        }else if(cnt == 3){
            result = 4;
        }else if(cnt == 2){
            result = 5;
        }else{
            result = 6;
        }
        return result;
    }
}
