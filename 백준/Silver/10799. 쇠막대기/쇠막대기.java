import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        int num = 0;
        int answer = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                stack.push(input[i]);
                num += 1;
            } else {
                num -= 1;
                if (stack.peek().equals("(") && input[i-1].equals("(")) {
                    answer += num;
                } else {
                    answer += 1;
                }
                stack.pop();
            }
        }
        System.out.println(answer);
    }
}