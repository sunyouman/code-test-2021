// https://programmers.co.kr/learn/courses/30/lessons/42895
import java.util.*;
import java.util.stream.*;

class Data{
    public int level;
    public int value;
    public Data(int l, int v) {
        this.level = l;
        this.value = v;
    }
    
    public boolean equals(Object o) {
        Data d = (Data)o;
        return this.level == d.level && this.value == d.value;
    }
    public int hashCode() {
        return this.level* 100000 + this.value;
    }
}

class Solution {
    public void addList(List<Data> list, int l1, int l2) {
        List<Data> l1List = list.stream().filter(d -> d.level == l1).collect(Collectors.toList());
        List<Data> l2List = list.stream().filter(d -> d.level == l2).collect(Collectors.toList());
        
        for (Data d1 : l1List) {
            for (Data d2: l2List) {
                if (d2.level == 1) {
                    int x = 0;
                    for (int i = 0; i < d1.level; i++)
                        x = x * 10 + d2.value;
                    if (d1.value == x)
                        list.add(new Data(l1 + l2, d1.value * 10 + d2.value));    
                }
                list.add(new Data(l1 + l2, d1.value + d2.value));
                list.add(new Data(l1 + l2, d1.value - d2.value));
                list.add(new Data(l1 + l2, d1.value * d2.value));
                if (d2.value != 0)
                    list.add(new Data(l1 + l2, d1.value / d2.value));
            }
        }
    }
    
    public int isFin(List<Data> list, int number) {
        System.out.println("");
        List<Data> res = list.stream()
            .filter(d -> d.value == number).sorted((a, b) -> a.level - b.level).collect(Collectors.toList());
        if (res.size() > 0)
            return res.get(0).level;
        else
            return -1;
    }
    public int solution(int N, int number) {
        int answer = 0;

        List<Data> list = new ArrayList<>();
        list.add(new Data(1, N));
        
        int level = 2;
        while ((answer = isFin(list, number)) == -1 && level < 9) {
            for (int i = 1; i < level; i++) {
                addList(list, i, level - i);
            }
            list = list.stream().distinct().collect(Collectors.toList());
            level ++;
        }
        return answer;
    }
}
