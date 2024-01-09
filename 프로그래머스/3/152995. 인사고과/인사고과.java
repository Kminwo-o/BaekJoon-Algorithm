import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanHo = scores[0];
        int wanHoTotal = wanHo[0] + wanHo[1];

        Arrays.sort(scores, (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);

        int maxScore = 0;
        for (int i = 0; i < scores.length; i++) {
            if (wanHo[0] < scores[i][0] && wanHo[1] < scores[i][1]) {
                return -1;
            }

            if (maxScore <= scores[i][1]) {
                if (wanHoTotal < scores[i][0] + scores[i][1]) {
                    answer++;
                }
                maxScore = scores[i][1];
            }
        }
        return answer;
    }
}