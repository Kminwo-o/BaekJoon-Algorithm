import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int h, w;
    static char[][] arr;
    static boolean[][] visited;
    static Queue<Fire> fireQueue;
    static Queue<SangGeun> sangGeunQueue;
    static int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class SangGeun {
        int x;
        int y;
        int time;

        public SangGeun(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static class Fire {
        int x;
        int y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void fire () {
        int all = fireQueue.size();
        for (int i = 0; i < all; i++) {
            Fire fire = fireQueue.poll();

            for (int j = 0; j < 4; j++) {
                int nx = fire.x + dir[j][0];
                int ny = fire.y + dir[j][1];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny] != '#' && arr[nx][ny] != '*') {
                    fireQueue.add(new Fire (nx, ny));
                    arr[nx][ny] = '*';
                }
            }
        }
    }
    public static int bfs () {
        while (!sangGeunQueue.isEmpty()) {
            fire();

            int sangAll = sangGeunQueue.size();
            for (int j = 0; j < sangAll; j++) {
                SangGeun sangGeun = sangGeunQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = sangGeun.x + dir[i][0];
                    int ny = sangGeun.y + dir[i][1];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) return sangGeun.time;
                    if (arr[nx][ny] != '.' || visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    sangGeunQueue.add(new SangGeun(nx, ny, sangGeun.time + 1));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new char[h][w];
            visited = new boolean[h][w];

            sangGeunQueue = new LinkedList<>();
            fireQueue = new LinkedList<>();

            for (int j = 0; j < h; j++) {
                char[] line = br.readLine().toCharArray();
                for (int k = 0; k < w; k++) {
                    arr[j][k] = line[k];

                    if (arr[j][k] == '@') {
                        sangGeunQueue.add(new SangGeun(j, k, 1));
                        visited[j][k] = true;
                    } else if (arr[j][k] == '*') {
                        fireQueue.add(new Fire(j, k));
                    }
                }
            }

            int answer = bfs();
            if (answer == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer);
            }
        }
    }
}