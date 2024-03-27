import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N;
    static String p;
    static StringBuilder sb = new StringBuilder();
    public static void AC(String command, ArrayDeque<Integer> deque) {
        boolean isRight = true;
        for (char cmd: command.toCharArray()) {
            if (cmd == 'R') {
                isRight = !isRight;
                continue;
            }
            if (isRight) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        strPrint(deque, isRight);
    }
    public static void strPrint(ArrayDeque<Integer> deque, boolean isRight) {
        sb.append('[');
        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> deque;
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            p = br.readLine();
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
            deque = new ArrayDeque<>();

            for (int j = 0; j < N; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(p, deque);
        }
        System.out.println(sb);
    }
}
