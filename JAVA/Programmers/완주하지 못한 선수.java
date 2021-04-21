import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int count[] = new int[participant.length];
        Hashtable<String, Integer> s = new Hashtable<>();
        for(int i = 0 ; i < completion.length;i++){
            if(s.get(completion[i])!= null){
                int cnt = s.get(completion[i]);
                cnt++;
                s.put(completion[i],cnt);
            }else{
                s.put(completion[i],1);
            }
        }
        for(int i = 0 ; i < participant.length; i++){
            if(s.get(participant[i]) == null){
                answer = participant[i];
            }else{
                int cnt = s.get(participant[i]);
                if(--cnt < 0){
                    answer = participant[i];
                }else{
                    s.put(participant[i],cnt);
                }
            }
        }
        return answer;
    }
}
