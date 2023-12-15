class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = -1;
        int time = 1;
        int now = health;
        for (int i = 0; i < attacks.length; i++) {
            int[] attack = attacks[i];

            int healTime = attack[0] - time;
            int heal = (healTime / bandage[0] * bandage[2]) + (healTime * bandage[1]);
            now += heal;

            if (now > health) {
                now = health;
            }

            time = attack[0]+1;
            now -= attack[1];

            if (now <= 0) {
                break;
            }
        }

        if (now <= 0) {
            return answer;
        } else {
            return now;
        }
    }
}