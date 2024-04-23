import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static class Node {
        int high;
        int idx;

        public Node(int high, int idx) {
            this.high = high;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        int cnt = 0;

        while (cnt != n) {
            int now = arr[cnt];

            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    if (stack.peek().high < now) {
                        stack.pop();
                        if (stack.isEmpty()) {
                            sb.append(0).append(" ");
                        }
                    } else {
                        sb.append(stack.peek().idx + 1).append(" ");
                        break;
                    }
                }
                stack.push(new Node(now, cnt));
            } else {
                sb.append(0).append(" ");
                stack.push(new Node(now, cnt));
            }

            cnt++;
        }
        System.out.println(sb);
    }
}