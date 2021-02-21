// https://programmers.co.kr/learn/courses/30/lessons/43162
import java.util.*;
import java.util.stream.*;

class Solution {
    public void BFS(int[][] computers, int x) {
        if (computers[x][x] == 0) return;
        // System.out.println("BFS : " + x);
        List<Integer> list = Arrays.stream(computers[x]).boxed().collect(Collectors.toList());
        computers[x][x] = 0;
        for (int idx =0; idx < list.size(); idx++) {
            // System.out.println("BFS in : " + (list.get(idx) == 1));
            if (list.get(idx) == 1)
                BFS(computers, idx);
        }
    }
    
    public int find(int[][] computers) {
        for (int i = 0 ; i < computers.length ; i++) {
            if (computers[i][i] == 1) {
                return i;
            }
        }
        return -1;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int pos = -1;
        while ((pos = find(computers)) != -1) {
            // System.out.println("BFS");
            BFS(computers, pos);
            answer++;
        }
        
        return answer;
    }
}
