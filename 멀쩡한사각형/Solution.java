// https://programmers.co.kr/learn/courses/30/lessons/62048

// w, h의 최대 공약수만큼 반복되는 패턴임을 이용
// 지나는 사각형의 개수는 경계선이 지날때마다 사각형이 하나씩 늘어남을 이용
class Solution {
    // public long gcd(int w, int h) {
    //     int c;
    //     while (h != 0) {
    //         c = w % h;
    //         w = h;
    //         h = c;
    //     }
    //     return w;
    // }
    
    public long gcd(int w, int h) {
        int min = Math.min(w, h);
        while (min != 1) {
            if (w % min ==0 && h % min == 0)
                return min;
            min --;
        }
        return 1;
    }
    
    public long solution(int w, int h) {
        long answer = 1;
        long gcd = gcd(w, h);
        answer = (long)w * h - (w + h - gcd);

        return answer;
    }
}
