// https://programmers.co.kr/learn/courses/30/lessons/17676

import java.text.*;
import java.util.*;

// range를 파싱해서 저장하고,
// range의 시작과 끝을 time list에 저장
// time list에 있는 시간에 대해서 몇개의 job이 있는지 확인
class Range implements Comparable {
    public long min;
    public long max;
    public Range(long min, long max) {
        this.min = min;
        this.max = max;
    }
    
    public int compareTo(Object obj) {
        Range x = (Range)obj;
        return (int)(this.min - x.min);
    }
    
    public boolean contain(long time) {
        return (min <= time && time <= max);
    }
}
class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        List<Range> list = new ArrayList<>();
        List<Long> timeList = new ArrayList<>();
        for (String line : lines) {
            String[] strs = line.split(" ");
            String dstr = strs[0] + " " + strs[1];
            int gap = (int)(Float.parseFloat(strs[2].split("s")[0]) * 1000);
            Date d = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                d = sdf.parse(dstr);
            } catch(ParseException e) {
                System.out.println(e.toString());
            }
            if (d != null) {
                list.add(new Range(d.getTime() - gap + 1, d.getTime() + 999));
                System.out.println((d.getTime() - gap) + " " +  (d.getTime() + 999));
                timeList.add(d.getTime() - gap + 1);
                timeList.add(d.getTime() + 999);
                
            }
            
        }
        long max = list.get(list.size() -1).max;
        Collections.sort(list);
        long min  = list.get(0).min;

        int maxCnt = 0;
        for (long i: timeList) {
            int cnt = 0;
            for (Range r : list) {
                if (r.contain(i))
                    cnt ++;
            }
            if (cnt > maxCnt) {
                System.out.println(i);
                maxCnt = cnt;
            }
        }
        answer = maxCnt;
        return answer;
    }
}
