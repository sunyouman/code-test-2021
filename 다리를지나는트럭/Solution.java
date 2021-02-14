// https://programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;
import java.util.stream.*;

// Bridge의 상태를 Queue의 형태로 그대로 만듦
// time을 1씩 증가시켜가면서 queue를 이동시킴
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truckIndex = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++)
            queue.add(0);
        Deque<Integer> trucks = new ArrayDeque<>(Arrays.stream(truck_weights).boxed().collect(Collectors.toList()));
        while (trucks.size() > 0) {
            answer ++;
            queue.poll();
            int sum = queue.stream().mapToInt(v -> v).sum();
            if (sum + trucks.peek() <= weight) {
                queue.add(trucks.poll());
            } else {
                queue.add(0);
            }
            if (trucks.size() == 0)
                answer += bridge_length;
        }
        return answer;
    }
}
