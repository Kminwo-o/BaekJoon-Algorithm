 import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Arrays.fill(answer, -1);
        
        // 목표 단어의 개수
        for (int i=0; i < targets.length; i++) {
            // 현재 목표 단어
            int cnt = 101;
            boolean flag = true;
            char[] charArr = targets[i].toCharArray();
            int sum = 0;
            
            // 목표단어의 문자 수
            for (int j=0; j < charArr.length; j++) {
                cnt = 101;
                // 키맵의 개수
                for (int k=0; k < keymap.length; k++) {
                    char[] keyStr = keymap[k].toCharArray();                    
                    
                    // 하나의 키맵
                    for (int t=0; t < keyStr.length; t++) {
                        if (cnt < t+1) {
                            break;
                        }
                        if (charArr[j] == keyStr[t]) {
                            if (cnt < 101) {
                                sum -= cnt;
                            }
                            sum += t+1;
                            cnt = t+1;
                            break;
                        }
                    }             
                }
                
                if (cnt == 101) {
                    flag = false;
                    break;
                }                
            }
            
            if (flag == true) {
                answer[i] = sum;
            }
            
        }
        return answer;
    }
}