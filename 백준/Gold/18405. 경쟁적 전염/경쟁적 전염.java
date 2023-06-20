import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class block implements Comparable<block> {
    int x;
    int y;
    int time;
    int num;

    public block(int x, int y, int time, int num) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.num = num;
    }

    @Override
    public int compareTo(block o) {
        if (time == o.time) {
            return num - o.num;
        }
        return time - o.time;
    }
}

public class Main {
    static int N, K, S, X, Y;
    static int[][] arr;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static PriorityQueue<block> q = new PriorityQueue<>();
    public static void bfs() {
        while (!q.isEmpty()) {
            block b = q.poll();

            if (b.time > S) {
                System.out.println(0);
                return;
            }
            if (b.x == X-1 && b.y == Y-1 && arr[b.x][b.y] != 0) {
                System.out.println(b.num);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = b.x + dir[i][0];
                int ny = b.y + dir[i][1];

                if ((0 > nx || nx >= N) || (0 > ny || ny >= N)) {
                    continue;
                }
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = b.num;
                    q.add(new block(nx, ny, b.time+1, b.num));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    q.add(new block(i, j, 0, arr[i][j]));
                }
            }
        }

        bfs();
    }
}