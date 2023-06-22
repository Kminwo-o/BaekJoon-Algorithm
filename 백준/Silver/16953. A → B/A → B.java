import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A,B;
    static Queue<long[]> q = new LinkedList<>();
    public static long bfs(int a) {
        int cnt = 1;
        q.add(new long[] {a, cnt});

        while (!q.isEmpty()) {
            long[] now = q.poll();
            if (now[0] == B) return now[1];
            if (now[0] < B) {
                if (now[0]*2 <= B) q.offer(new long[] {now[0]*2, now[1]+1});
                if (now[0]*10+1 <= B) q.offer(new long[] {now[0]*10+1, now[1]+1});
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        System.out.println(bfs(A));
    }
}