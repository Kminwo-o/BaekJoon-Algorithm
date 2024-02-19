import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int answer = -1;
    static boolean isCycle = false;
    static int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void dfs (int cnt, int x, int y) {
        int number = Character.getNumericValue(map[x][y]);

        dp[x][y] = cnt;
        answer = Math.max(cnt, answer);
        if (isCycle) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + (number * dir[i][0]);
            int ny = y + (number * dir[i][1]);

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (map[nx][ny] == 'H') continue;
            if (cnt < dp[nx][ny]) continue;

            if (visited[nx][ny]) {
                isCycle = true;
                return;
            }

            visited[nx][ny] = true;
            dfs(cnt + 1, nx, ny);
            visited[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dp = new int[n][m];
        visited = new boolean[n][m];
        visited[0][0] = true;
        dfs(1, 0, 0);

        if (isCycle) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}