package Programmer;

import java.util.function.Function;

public class 광고삽입 {

    static long[] second;
    static Function<String, Integer> stoi = Integer::parseInt;

    public String solution(String play_time, String adv_time, String[] logs) {

        int playTime = stringToSecond(play_time);
        int advTime = stringToSecond(adv_time);
        second = new long[playTime + 1];
        for (String log : logs) {
            String[] times = log.split("-");
            int startTime = stringToSecond(times[0]);
            int endTime = stringToSecond(times[1]);
            second[startTime]++;
            second[endTime]--;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= playTime; j++) {
                second[j] += second[j - 1];
            }
        }
        long maxSum = second[advTime - 1];
        long result = 0;
        for (int i = 0; i + advTime <= playTime; i++) {
            long sum = second[i + advTime] - second[i];
            if (sum > maxSum) {
                maxSum = sum;
                result = i + 1;
            }
        }

        return String.format("%02d:%02d:%02d", result / (60 * 60), (result / 60) % 60, result % 60);
    }

    private int stringToSecond(String s) {
        String[] time = s.split(":");
        return 3600 * stoi.apply(time[0]) + 60 * stoi.apply(time[1]) + stoi.apply(time[2]);
    }

}