import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class block {
    int x;
    int y;

    block (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;
    static String[] arr;
    static int[][] visited;

    public static void bfs(int x, int y) {
        Queue<block> q = new LinkedList<>();
        q.add(new block(x, y));
        visited[x][y] = 0;

        while (!q.isEmpty()) {
            block now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];

                if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n)) {
                    if (visited[nx][ny] <= visited[now.x][now.y]) continue;

                    if (arr[nx].charAt(ny) == '1') {
                        q.add(new block(nx, ny));
                        visited[nx][ny] = visited[now.x][now.y];
                    } else {
                        q.add(new block(nx, ny));
                        visited[nx][ny] = visited[now.x][now.y]+1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        bfs(0,0);

        System.out.println(visited[n-1][n-1]);
    }
}