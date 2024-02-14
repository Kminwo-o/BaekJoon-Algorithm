class Solution {
    // dfs
    static int answer, end;
    static int[] picksList;
    static String[] mineral;
    
    public void dfs (int tired, int gokgange, int idx) {
        if (tired >= answer) return;
        if (idx == end || gokgange == 0) {
            answer = Math.min(answer, tired);
            return;
        }
        
        int use = 0;
        int tmpTired = 0;
        
        // 다이아
        if (picksList[0] > 0) {
            picksList[0]--;
            for (int i = 0; i < 5; i++) {
                if (idx + use == end) break;
                tmpTired++;
                use++;
            }
            dfs(tired + tmpTired, gokgange - 1, idx + use);
            picksList[0]++;
        }
        
        use = 0;
        tmpTired = 0;
        
        // 철
        if (picksList[1] > 0) {
            picksList[1]--;
            for (int i = 0; i < 5; i++) {
                if (idx + use == end) break;
                if (mineral[idx + use].equals("diamond")) {
                    tmpTired += 5;
                } else {
                    tmpTired += 1;
                }
                use++;
            }
            dfs(tired + tmpTired, gokgange - 1, idx + use);
            picksList[1]++;
        }
        
        use = 0;
        tmpTired = 0;
        
        // 돌
        if (picksList[2] > 0) {
            picksList[2]--;
            for (int i = 0; i < 5; i++) {
                if (idx + use == end) break;
                if (mineral[idx + use].equals("diamond")) {
                    tmpTired += 25;
                } else if (mineral[idx + use].equals("iron")) {
                    tmpTired += 5;
                } else {
                    tmpTired += 1;
                }
                use++;
            }
            dfs(tired + tmpTired, gokgange - 1, idx + use);
            picksList[2]++;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        picksList = picks;
        mineral = minerals;
        end = minerals.length;
        answer = Integer.MAX_VALUE;
        
        int gokgange = 0;
        for (int i = 0; i < picks.length; i++) {
            gokgange += picks[i];
        }
        
        dfs (0, gokgange, 0);
        
        return answer;
    }
}