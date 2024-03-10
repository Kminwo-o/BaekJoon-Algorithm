import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int length = n - k;

        String[] numbers = br.readLine().split("");
        Stack<Integer> stack = new Stack<>();

        for (String num : numbers) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < Integer.valueOf(num)) {
                stack.pop();
                k--;
            }

            stack.push(Integer.valueOf(num));
        }

        while (true) {
            if (length == stack.size()) {
                break;
            }

            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
}