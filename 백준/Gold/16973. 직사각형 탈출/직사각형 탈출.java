import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Square{
    int x;
    int y;
    int cnt;

    public Square(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    static int n, m;
    static int h,w,sr,sc,fr,fc;
    static int[][] dir = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;

    static boolean[][] visited;
    static List<int[]> wall;
    static int[] now;
    public static boolean check(int x, int y) {
        for (int i = 0; i < wall.size(); i++) {
            now = wall.get(i);
            if (x <= now[0] && now[0] <= x + h - 1 && y <= now[1] && now[1] <= y + w - 1) {
                return false;
            }
        }
        return true;
    }

    public static int bfs() {
        Queue<Square> queue = new LinkedList<>();
        queue.add(new Square(sr, sc, 0));
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            Square square = queue.poll();


            if (square.x == fr && square.y == fc) {
                return square.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = square.x + dir[i][0];
                int ny = square.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny])
                    continue;
                if (nx + h - 1 >= n || ny + w - 1 >= m)
                    continue;

                if (check(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.add(new Square(nx, ny, square.cnt + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        wall = new ArrayList<>();
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    wall.add(new int[] {i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken()) - 1;
        sc = Integer.parseInt(st.nextToken()) - 1;
        fr = Integer.parseInt(st.nextToken()) - 1;
        fc = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(bfs());
    }
}