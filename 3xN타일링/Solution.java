// https://programmers.co.kr/learn/courses/30/lessons/12902
class Solution {
    public int solution(int n) {
        long[] dp = new long[n / 2 + 1];
        dp[1] = 3;
        dp[0] = 1;
        
        int cnt = 2;
        long add = 0;
        do {
            cnt += 2;
            add += (dp[cnt/2 -2] * 2); 
            dp[cnt / 2] = (dp[cnt/2 -1] * 3) + add;
            add %= 1000000007;
            dp[cnt / 2] %= 1000000007;
        } while (cnt != n);
        return (int)(dp[cnt / 2] % 1000000007);
    }
}
