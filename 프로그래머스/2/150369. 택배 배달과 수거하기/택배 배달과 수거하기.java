class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int del_distance = 0;
        int pick_distance = 0;
        
        for (int i = n-1; i >= 0; i--) {
            del_distance -= deliveries[i];
            pick_distance -= pickups[i];
            
            while (del_distance < 0 || pick_distance < 0) {
                del_distance += cap;
                pick_distance += cap;
                answer += ((i+1)*2);
            }
        }
        
        return answer;
    }
}