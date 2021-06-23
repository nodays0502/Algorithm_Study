package self;

import java.util.HashMap;

public class 다단계_칫솔_판매 {
    static int parents[];
    static int money[];
    static HashMap<String,Integer> map = new HashMap<>();
    static void sell(String[] enroll,String name, int nmoney){
    //    int now = Arrays.asList(enroll).indexOf(name);
        int now = map.get(name);
        if(parents[now] == now) {
            int temp = nmoney/10;
            money[now] += (nmoney - temp);
            return ;
        }else{
            int temp = nmoney/10;

         //       System.out.println(now);
         //       System.out.println(nmoney);
            money[now] += (nmoney - temp);
            if(temp != 0){
                sell(enroll,enroll[parents[now]],temp);
            }

        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        parents = new int[enroll.length];
        money = new int[enroll.length];
        for(int i = 0 ; i < enroll.length ; i++){
            map.put(enroll[i],i);
        }
        for(int i = 0 ; i < referral.length ; i++){
            int now = i;
       //     int nowParent = Arrays.asList(enroll).indexOf(referral[i]);
            int nowParent = i;
            if(map.containsKey(referral[i]))
                nowParent = (int)map.get(referral[i]);
       //     if(nowParent == -1) nowParent = now;
            parents[now] = nowParent; 
        }
        
        for(int i = 0 ; i < seller.length ; i++){
            sell(enroll, seller[i], amount[i]*100);
        }
        
        for(int i = 0 ; i < enroll.length ; i++){
            answer[i] = money[i];
        }
        return answer;
    }
}
