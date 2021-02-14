// https://programmers.co.kr/learn/courses/30/lessons/12899

// 3진법과 비슷하게 풀지만,
// 3으로 나누어떨어질 때, 4를 append하고, 몫에서 1을 뺀다.
import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int div = n % 3;
            n /= 3;
            builder.append(div == 0 ? 4 : div);
            if (div == 0) n --;
        }
        builder.reverse();
        String answer = builder.toString();
        return answer;
    }
}
