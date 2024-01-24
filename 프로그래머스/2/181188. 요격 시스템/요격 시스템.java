import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (x, y) -> x[0] - y[0]);
        
        int preStart = targets[0][0];
        int preEnd = targets[0][1];
        
        for (int i = 0; i < targets.length; i++) {
            if (answer == 0) {
                answer++;
                continue;
            }
            
            int curStart = targets[i][0];
            int curEnd = targets[i][1];
            
            // 현재보다 시작은 크고, 끝은 작다면 같은 미사일로 요격이 가능하다.
            // 4로 끝나는 지점과 4로 시작하는 미사일은 함께 요격될 수 없다.
            if (preStart <= curStart && curStart < preEnd) {
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
                
            } else {
                preStart = curStart;
                preEnd = curEnd;
                answer++;
            }
        }
        return answer;
    }
}