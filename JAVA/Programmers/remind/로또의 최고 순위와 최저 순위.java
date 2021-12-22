import java.util.*;
class Solution {
    static int cal(int num){
        if(num == 6){
            return 1;
        }else if(num == 5){
            return 2;
        }else if(num == 4){
            return 3;
        }else if(num == 3){
            return 4;
        } else if(num == 2){
            return 5;
        } else {
            return 6;
        }
    } 
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet<>();
        for(int win_num : win_nums){
            set.add(win_num);
        }
        int count = 0;
        int zeroCnt = 0;
        for(int lotto : lottos){
            if(lotto == 0){
                zeroCnt++;    
            }else if(set.contains(lotto)){
                count++;
            }
        }
        answer = new int[] {cal(count + zeroCnt),cal(count)};
        return answer;
    }
}
