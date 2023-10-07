import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> now = new ArrayList<>();
        Arrays.sort(nums);
        int count = 0;
        while (answer < nums.length / 2 && count < nums.length) {
            if (now.contains(nums[count])) {
                count++;
                continue;
            }
            now.add(nums[count]);
            count++;
            answer++;
        }
            
        return answer;
    }
}