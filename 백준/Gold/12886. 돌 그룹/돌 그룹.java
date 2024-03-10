import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int a, b, c, total;
    static boolean[][] visited;

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int z = total - (x+y);

            if (x == y && y == z) {
                return 1;
            }

            for (int[] cur: new int[][] {{x, y}, {x, z}, {y, z}}) {
                if (cur[0] == cur[1]) continue;
                if (cur[0] > cur[1]) {
                    int tmp = cur[0];
                    cur[0] = cur[1];
                    cur[1] = tmp;
                }

                int value = cur[0];
                cur[0] += value;
                cur[1] -= value;

                if (visited[cur[0]][cur[1]]) continue;
                queue.add(new int[] {cur[0], cur[1]});
                visited[cur[0]][cur[1]] = true;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        total = a + b + c;
        visited = new boolean[total][total];

        if (total % 3 != 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
    }
}