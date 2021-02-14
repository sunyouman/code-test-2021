// https://programmers.co.kr/learn/courses/30/lessons/49993

// skill에 대해서 알파벳 RUT를 만든다.
// skill tree에 대해서 RUT로 변환 후, 0이 아닌 숫자가 순차로 증가하는지 확인

class Solution {
    public boolean judgement(int[] skillLevel, String skill_tree) {
        int[] skillTreeLevel = new int[skill_tree.length()];
        for (int i =0 ; i < skill_tree.length(); i++)
            skillTreeLevel[i] = skillLevel[skill_tree.charAt(i) - 'A'];
        int max = 0;
        // System.out.println(skill_tree);
        for (int x : skillTreeLevel) {
            // System.out.println(x + " " + max);
            if (x == 0) continue;
            if (max <= x && x - max == 1) {
                max = x;
            } else {
                return false;
            }
        }
        return true;
    }
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skillLevel = new int[26];
        for (int i =0 ; i < 26; i++)
            skillLevel[i] = 0;

        for (int i = 0; i < skill.length(); i++)
            skillLevel[skill.charAt(i) - 'A'] = i + 1;
        
        int cnt = 0;
        for (String skillTree : skill_trees)
            if (judgement(skillLevel, skillTree))
                cnt ++;

        answer = cnt;
        return answer;
    }
}
