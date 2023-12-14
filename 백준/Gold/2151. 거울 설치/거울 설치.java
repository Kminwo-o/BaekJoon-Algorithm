import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] start;
    static int[] end;
    static int[][] dir = {{-1, 0}, {0 , -1}, {1, 0}, {0, 1}};
    static class Mirror implements Comparable<Mirror>{
        int x;
        int y;
        int mirror;
        int dir;

        public Mirror(int x, int y, int mirror, int dir) {
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.dir = dir;
        }

        @Override
        public int compareTo(Mirror o) {
            return this.mirror - o.mirror;
        }
    }
    public static void findDir(PriorityQueue<Mirror> queue, boolean[][][] visited) {
        for (int i = 0; i < 4; i++) {
            int nx = start[0] + dir[i][0];
            int ny = start[1] + dir[i][1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != '*') {
                queue.add(new Mirror(start[0], start[1], 0, i));
            }
        }
    }

    public static void bfs() {
        PriorityQueue<Mirror> queue = new PriorityQueue<>();
        boolean[][][] visited = new boolean[N][N][4];
        findDir(queue, visited);

        while (!queue.isEmpty()) {
            Mirror mirror = queue.poll();

            visited[mirror.x][mirror.y][mirror.dir] = true;

            if (mirror.x == end[0] && mirror.y == end[1]) {
                System.out.println(mirror.mirror);
                return;
            }

            int nx = mirror.x + dir[mirror.dir][0];
            int ny = mirror.y + dir[mirror.dir][1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != '*') {
                if (!visited[nx][ny][mirror.dir]) {
                    if (map[nx][ny] == '!') {
                        int nDir = (mirror.dir + 3) % 4;
                        queue.add(new Mirror(nx, ny, mirror.mirror + 1, nDir));

                        nDir = (mirror.dir + 1) % 4;
                        queue.add(new Mirror(nx, ny, mirror.mirror + 1, nDir));
                    }
                    queue.add(new Mirror(nx, ny, mirror.mirror, mirror.dir));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '#' && !flag) {
                    start = new int[] {i, j};
                    flag = true;
                } else if (map[i][j] == '#' && flag){
                    end = new int[] {i, j};
                }
            }
        }
        bfs();
    }
}
