import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dir = new int[][] {{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {1, 0, 0}, {-1, 0, 0}};
    static int L, R, C;
    static int[] start, end;
    static char[][][] map;
    public static class Node {
        int floor;
        int x;
        int y;
        int move;

        public Node(int floor, int x, int y, int move) {
            this.floor = floor;
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start[0], start[1], start[2], 0));
        boolean[][][] visited = new boolean[L][R][C];
        visited[start[0]][start[1]][start[2]] = true;

        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (ans < now.move) continue;
            if (now.floor == end[0] && now.x == end[1] && now.y == end[2]) {
                ans = now.move;
            }

            for (int i = 0; i < 6; i++) {
                int nf = now.floor + dir[i][0];
                int nx = now.x + dir[i][1];
                int ny = now.y + dir[i][2];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && nf >= 0 && nf < L) {
                    if (visited[nf][nx][ny] || map[nf][nx][ny] == '#') continue;
                    visited[nf][nx][ny] = true;
                    queue.add(new Node(nf, nx, ny, now.move + 1));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            map = new char[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    map[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k] == 'S') {
                            start = new int[] {i, j, k};
                        }
                        if (map[i][j][k] == 'E') {
                            end = new int[] {i,j,k};
                        }
                    }
                }
                br.readLine();
            }

            int answer = bfs();
            if (answer != Integer.MAX_VALUE) {
                System.out.println("Escaped in " + answer + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }
}