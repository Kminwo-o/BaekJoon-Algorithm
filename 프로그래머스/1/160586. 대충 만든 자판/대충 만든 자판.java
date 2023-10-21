import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];        
        
        for(int i=0; i<targets.length; i++) {
        	for(int j=0; j<targets[i].length(); j++) {
        		int cnt = 101;
        		for(int k = 0; k<keymap.length; k++) {
        			int loc = keymap[k].indexOf(targets[i].charAt(j));
        			if(loc != -1) {
        				if(cnt > loc) {
        					cnt = loc;
        				}
        			}
        		}
        		if(cnt == 101) {
        			answer[i] = -1;
        			break;
        		}
        		else {
        			answer[i] += cnt +1;
        		}        		        		
        	}
        }
        
        return answer;
    }
}