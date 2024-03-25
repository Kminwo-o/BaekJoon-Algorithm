import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        int answer = 0;
        int num = 1;
        boolean flag = false;

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                stack.push(input[i]);
                num *= 2;
            } else if (input[i].equals("[")) {
                stack.push(input[i]);
                num *= 3;
            } else {
                if (input[i].equals(")")) {
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        flag = true;
                        break;
                    }
                    if (input[i-1].equals("(")) {
                        answer += num;
                    }
                    stack.pop();
                    num /= 2;
                } else if (input[i].equals("]")) {
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        flag = true;
                        break;
                    }
                    if (input[i-1].equals("[")) {
                        answer += num;
                    }
                    stack.pop();
                    num /= 3;
                }
            }
        }

        if (flag || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}