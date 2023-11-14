import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        int[] ans = new int[N];

        for (int i = 1; i < N+1; i++) {
            queue.add(i);
        };

        System.out.print("<");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                int now = queue.poll();
                queue.offer(now);
            }

            ans[i] = queue.poll();
        }

        for (int i = 0; i < N; i++) {
            System.out.print(ans[i]);

            if (i != N-1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}