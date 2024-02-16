import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long x = queue.poll();
            long y = queue.poll();

            queue.add(x + y);
            queue.add(x + y);
        }

        long answer = queue.stream().mapToLong(i -> i).sum();
        System.out.println(answer);
    }
}