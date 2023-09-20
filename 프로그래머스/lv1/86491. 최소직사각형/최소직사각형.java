class Solution {
    public int solution(int[][] sizes) {
        int garo = 0;
        int sero = 0;
        int now_garo, now_sero;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                now_garo = sizes[i][1];
                now_sero = sizes[i][0];
            } else {
                now_garo = sizes[i][0];
                now_sero = sizes[i][1];
            }
            
            garo = Math.max(garo, now_garo);
            sero = Math.max(sero, now_sero);
        }
        
        int answer = garo * sero;
        return answer;
    }
}