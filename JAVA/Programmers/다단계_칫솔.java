import java.util.*;

class Solution {
    static int parents[];
    // static String people[];
    static Map<String , Integer> people;
    static int moneys[];
    static void cal(int name , int money){
        // int index = 0;
        // for(int i = 0 ; i < people.length ; i++){
        //     if(name.equals(people[i])){
        //         index = i;
        //         break;
        //     }
        // }
        int index = name;
        if(parents[index] == -1){
            moneys[index] += money - money / 10;
        }else{
            moneys[index] += money - money / 10;
            cal(parents[index],money / 10);
        }
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer;
        parents = new int[enroll.length];
        // people= new String[referral.length];
        people = new HashMap<>();
        moneys= new int[enroll.length];
        for(int i = 0 ; i < enroll.length; i++){
            // people[i] = enroll[i];
            people.put(enroll[i],i);
        }
        
        for(int i = 0 ; i < enroll.length; i++){
            // people[i] = enroll[i];
            if("-".equals(referral[i])){
                parents[i] = -1;
            }else{
                int index = people.get(referral[i]);
                parents[i] = index;
            }

        }
    
        for(int i = 0 ; i < seller.length ; i++){
            cal(people.get(seller[i]), amount[i]*100);
            // System.out.println(Arrays.toString(moneys));
        }
        answer = moneys;
        return answer;
    }
}
