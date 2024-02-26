import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k, w, h;
    static int[][] arr;
    static int[][] horseDir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1 , 2}, {2, 1}, {2 , -1}, {1, -2}};
    static int[][] monkeyDir = {{-1, 0}, {1 ,0}, {0, -1}, {0, 1}};
    static boolean[][][] visited;
    static class Monkey {
        int x;
        int y;
        int horseMoving;
        int cnt;

        public Monkey(int x, int y, int horseMoving, int cnt) {
            this.x = x;
            this.y = y;
            this.horseMoving = horseMoving;
            this.cnt = cnt;
        }
    }
    public static int bfs () {
        Queue<Monkey> queue = new LinkedList<>();
        queue.add(new Monkey(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Monkey monkey = queue.poll();

            if (monkey.x == h - 1 && monkey.y == w - 1) {
                return monkey.cnt;
            }

            if (monkey.horseMoving < k) {
                for (int i = 0; i < 8; i++) {
                    int nx = monkey.x + horseDir[i][0];
                    int ny = monkey.y + horseDir[i][1];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (arr[nx][ny] != 1 && !visited[nx][ny][monkey.horseMoving + 1]) {
                            visited[nx][ny][monkey.horseMoving + 1] = true;
                            queue.add(new Monkey(nx, ny, monkey.horseMoving + 1, monkey.cnt + 1));
                        }
                    }
                }
            }
            if (monkey.horseMoving <= k) {
                for (int i = 0; i < 4; i++) {
                    int nx = monkey.x + monkeyDir[i][0];
                    int ny = monkey.y + monkeyDir[i][1];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (arr[nx][ny] != 1 && !visited[nx][ny][monkey.horseMoving]) {
                            visited[nx][ny][monkey.horseMoving] = true;
                            queue.add(new Monkey(nx, ny, monkey.horseMoving, monkey.cnt + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][w];
        visited = new boolean[h][w][31];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }
}