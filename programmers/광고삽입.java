package Programmer;

import java.util.function.Function;

public class 광고삽입 {
    static Function<String, Integer> stoi = Integer::parseInt;

    static class Time {

        static int second[];
        static int tempCnt[];

        void makeArray(int size) {
            second = new int[size];
            tempCnt = new int[size];
        }

        int solve(int t) {
            int resultIndex = 0;
            long result = 0;
            long sum = 0;
            int cnt = 0;
            for (int i = 0; i < second.length; i++) {
                cnt += second[i];
                if(i >= t){
                    cnt -= tempCnt[i-t];
                }
                tempCnt[i] = cnt;
                sum += cnt;

                if (result < sum) {
                    result = sum;
                    resultIndex = Math.max(i - t+1, 0);
                }
            }
            return resultIndex;
        }

        static int stringToTime(String s) {
            String[] split = s.split(":");
            int second = makeSecond(split);
            return second;
        }

        static void logToTime(String s) {
            String[] times = s.split("-");
            String[] start = times[0].split(":");
            String[] end = times[1].split(":");
            int startSecond = makeSecond(start);
            int endSecond = makeSecond(end);
            second[startSecond]++;
            second[endSecond]--;
        }

        static int makeSecond(String[] s) {
            return stoi.apply(s[0]) * 3600 + stoi.apply(s[1]) * 60 + stoi.apply(s[2]);
        }

        static private String SecondToString(int time) {
            int[] times = new int[3];
            int mod = 3600;
            for(int i = 0 ; i< 3; i++){
                times[i] = time/mod;
                time %= mod;
                mod /= 60;
            }
            StringBuilder sb = new StringBuilder();
            for(int t : times){
                if(t < 10){
                    sb.append("0"+Integer.toString(t));
                }else{
                    sb.append(Integer.toString(t));
                }
                sb.append(":");
            }
            sb.setLength(sb.length()-1);
            return sb.toString();
        }


    }

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        Time time = new Time();
        int playTime = Time.stringToTime(play_time);
        time.makeArray(playTime + 1);
        int advTime = Time.stringToTime(adv_time);
        for (String log : logs) {
            Time.logToTime(log);
        }
        int result = time.solve(advTime);
        answer = Time.SecondToString(result);

        return answer;
    }

}