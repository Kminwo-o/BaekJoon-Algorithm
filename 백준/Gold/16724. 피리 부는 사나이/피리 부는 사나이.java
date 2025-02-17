import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] visited;
    static char[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int cnt = 0, idx = 1;

    public static void bfs (int i, int j) {
        visited[i][j] = idx;

        int nr = 0, nc = 0;
        switch (map[i][j]) {
            case 'U':
                nr = i + dir[0][0];
                nc = j + dir[0][1];
                break;
            case 'D':
                nr = i + dir[1][0];
                nc = j + dir[1][1];
                break;
            case 'L':
                nr = i + dir[2][0];
                nc = j + dir[2][1];
                break;
            case 'R':
                nr = i + dir[3][0];
                nc = j + dir[3][1];
                break;
        }

        if (visited[nr][nc] == 0) {
            bfs(nr, nc);
        } else {
            if (visited[nr][nc] == idx) cnt++;
            idx++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        visited = new int[n][m];
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }
}