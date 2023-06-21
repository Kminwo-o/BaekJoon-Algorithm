import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A;
    static int[] num_lst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        num_lst = new int[A];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            num_lst[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A; i++) {
            while (!stack.isEmpty() && num_lst[stack.peek()] < num_lst[i]) {
                num_lst[stack.pop()] = num_lst[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            num_lst[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A; i++) {
            sb.append(num_lst[i]).append(" ");
        }
        System.out.println(sb);
    }
}