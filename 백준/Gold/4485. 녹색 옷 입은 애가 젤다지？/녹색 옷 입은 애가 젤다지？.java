import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr, visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Link implements Comparable<Link>{
        int x;
        int y;
        int loopy;
        public Link (int x, int y, int loopy) {
            this.x = x;
            this.y = y;
            this.loopy = loopy;
        }

        @Override
        public int compareTo(Link o) {
            return loopy - o.loopy;
        }
    }
    public static int Prim(int x, int y) {
        PriorityQueue<Link> queue = new PriorityQueue<>();
        queue.add(new Link(x, y, arr[x][y]));

        while (!queue.isEmpty()) {
            Link link = queue.poll();

            if (visited[link.x][link.y] < link.loopy) {
                continue;
            }

            if (link.x == N-1 && link.y == N-1) {
                return link.loopy;
            }

            for (int i = 0; i < 4; i++) {
                int nx = link.x + dir[i][0];
                int ny = link.y + dir[i][1];

                if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
                    if (visited[nx][ny] > link.loopy + arr[nx][ny]) {
                        queue.add(new Link(nx, ny, link.loopy + arr[nx][ny]));
                        visited[nx][ny] = link.loopy + arr[nx][ny];
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 0;
        while (true) {
            T++;
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            arr = new int[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], Integer.MAX_VALUE);
            }
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("Problem " + T + ": " + Prim(0,0));
        }
    }
}