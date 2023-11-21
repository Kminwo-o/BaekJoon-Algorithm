import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        Stack<Integer> stack = new Stack<>();

        int now = 1;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(sb.toString()) != null) {
                stack.push(map.get(sb.toString()));
                sb.setLength(0);
            }

            if (arr[i] >= '0' && arr[i] <= '9') {
                stack.push(Character.getNumericValue(arr[i]));
                continue;
            }
            sb.append(arr[i]);
        }

        if (sb.length() != 0) {
            stack.push(map.get(sb.toString()));
            }

        while (!stack.isEmpty()) {
            answer += stack.pop() * now;
            now *= 10;
        }

        return answer;
    }
}