// https://programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;
import java.util.stream.*;

// 첫번째 작업 완료까지의 날짜 개산해서, 나머지 작업도 반영
// 100%가 넘은 작업의 수 계산해서 리스트에 넣고
// 위에 과정을 반복

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int position = 0;
        while (position < progresses.length) {
            int remain = 100 - progresses[position];
            int firstSpeed = speeds[position];
            int end = remain / firstSpeed;
            end += remain % firstSpeed == 0 ? 0 : 1;
            for (int i = position; i < progresses.length; i++)
                progresses[i] = progresses[i] + speeds[i] * end;
            int cnt = 0;
            while (position < progresses.length && progresses[position] >= 100) {
                cnt ++;
                position ++;
            }
            list.add(cnt);
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
