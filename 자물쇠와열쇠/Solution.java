// https://programmers.co.kr/learn/courses/30/lessons/60059
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int keylen = key.length;
        int whole = (keylen-1) + lock.length;

        int keyhole = 0;
        for (int i = 0; i < lock.length ; i ++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0) keyhole ++;
            }
        }

        for (int i = 0; i < whole ; i ++) {
            for (int j = 0; j < whole; j++) {
                for (int d = 0; d < 4; d++) {
                    boolean success = true;
                    int cnt = 0;
                    for (int ki = 0; ki < keylen; ki++) {
                        for (int kj = 0; kj < keylen; kj++) {
                            int kki = 0, kkj = 0;
                            switch (d) {
                                case 0:
                                    kki = ki;
                                    kkj = kj;
                                    break;
                                case 1:
                                    kki = kj;
                                    kkj = keylen-ki-1;
                                    break;
                                case 2:
                                    kki = keylen-ki-1;
                                    kkj = keylen-kj-1;
                                    break;
                                case 3:
                                    kki = keylen-kj-1;
                                    kkj = ki;
                                    break;
                            }
                            int li = i - keylen + 1 + ki;
                            int lj = j - keylen + 1 + kj;
                            if (li < 0 || li >= lock.length || lj < 0 || lj >= lock.length)
                                continue;
                            if (key[kki][kkj] + lock[li][lj] != 1) {
                                success = false;
                                break;
                            } else if (lock[li][lj] == 0) {
                                cnt ++;
                            }
                        }
                    }
                    if (success && cnt == keyhole)
                        return true;
                }
            }
        }
        return false;
    }
}
