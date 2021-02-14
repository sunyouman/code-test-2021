// https://programmers.co.kr/learn/courses/30/lessons/42587

// queue에서 1개 빼서 priority 최대값이면 빼내고, 아니면 맨뒤로 add
import java.util.*;
import java.util.stream.*;

public class PrintObj {
    public int priority;
    public int location;
    public PrintObj(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int cnt = 0;
        List<PrintObj> list = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            list.add(new PrintObj(priorities[i], i));
        }
        
        PrintObj result = null;
        int answer = 0;
        while (list.size() > 0 && (result = list.remove(0)) != null) {
            // stream api를 이용한 max
            int max = list.stream().mapToInt(p -> p.priority).max().orElse(0);

            // for문을 이용한 max
            // int max  = 0;
            // for (int i =0; i < list.size(); i++) {
            //     if (max < list.get(i).priority) {
            //         max = list.get(i).priority;
            //     }
            // }
            // System.out.println(result.priority + " "+ max);
            if (result.priority < max)
                list.add(result);
            else {
                answer ++;
                if (location == result.location)
                    break;
            }
        }
        return answer;
    }
}
