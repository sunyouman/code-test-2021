// https://programmers.co.kr/learn/courses/30/lessons/68646
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] minLeft = new int[a.length];
        int[] minRight = new int[a.length];
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            left = Math.min(left, a[i]);
            minLeft[i] = left;
            right = Math.min(right, a[a.length - i - 1]);
            minRight[a.length - i -1] = right;
        }
        
        for (int i = 0; i < a.length; i++) {
            if (i == 0 ||
                i == a.length -1 ||
                a[i] < minLeft[i-1] || a[i] < minRight[i+1])
                answer ++;
        }
        return answer;
    }
}
