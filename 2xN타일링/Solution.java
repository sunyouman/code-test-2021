// https://programmers.co.kr/learn/courses/30/lessons/12900
class Solution {
    public int solution(int n) {
        int answer = 0;

        int a = 1;
        int b = 2;
        
        int cnt = 3;
        int x = 0;
        while (cnt-1 < n) {
            x = (b + a) % 1000000007;
            a = b;
            b = x;
            cnt ++;
        }
        return x;
    }
}
