// https://programmers.co.kr/learn/courses/30/lessons/62050

import java.util.*;
import java.util.stream.*;

class Point implements Comparable {
    public int x;
    public int y;
    public int diff;
    public Point(int x, int y, int diff) {
        this.x = x;
        this.y = y;
        this.diff = diff;
    }
    
    public int compareTo(Object o) {
        Point p = (Point) o;
        return this.diff - p.diff;
    }
}

class Solution {
    public int solution(int[][] land, int height) {
        int answer = 0;
        int N = land.length;
        PriorityQueue<Point> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[N][];
        for (int i = 0; i < N; i++)
            visit[i] = new boolean[N];
        
        int min = Integer.MAX_VALUE;
        int minX = 0, minY = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (min > land[i][j]) {
                    min = land[i][j];
                    minX = i;
                    minY = j;
                }
        
        Point p = new Point(minX, minY, 0);
        queue.add(p);
        int[] xx = {-1, 0, 1, 0};
        int[] yy = {0, -1, 0, 1};
        while (queue.size() > 0) {
            p = queue.poll();
            int x = p.x;
            int y = p.y;
            if (visit[x][y]) continue;

            if (p.diff > height) answer += p.diff;
            visit[x][y] = true;
            for (int i =0; i < 4; i++) {
                int nx = x + xx[i];
                int ny = y + yy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && visit[nx][ny] == false) {
                    queue.add(new Point(nx, ny, Math.abs(land[nx][ny] - land[x][y])));
                }
            }
        }
        
        return answer;
    }
}
