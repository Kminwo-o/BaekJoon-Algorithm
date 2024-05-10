import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int building = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {
                if (stack.peek() <= building) {
                    stack.pop();
                } else break;
            }

            answer += stack.size();
            stack.push(building);
        }

        System.out.println(answer);
    }
}