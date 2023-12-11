import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static Shark[] sharks;
    static List<Integer> fishing = new ArrayList<>();
    static int r, c, m;
    static int[][] dir = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static class Shark{
        int num;
        int x;
        int y;
        int speed;
        int dir;
        int size;

        public Shark(int num, int x, int y, int speed, int dir, int size) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }
    static void fishing(int y) {
        for (int i = 0; i < r; i++) {
            if (map[i][y] >= 1) {
                fishing.add(map[i][y]);
                map[i][y] = 0;
                return;
            }
        }
    }
    static void sharkMove() {
        Queue<Integer> liveShark = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] >= 1) {
                    liveShark.add(map[i][j]);
                }
            }
        }
        map = new int[r][c];
        while (!liveShark.isEmpty()) {
            int now = liveShark.poll();
            Shark shark = sharks[now];

            if (shark.dir == 0 || shark.dir == 2) {
                shark.speed %= (r - 1) * 2;
            } else {
                shark.speed %= (c - 1) * 2;
            }

            for (int j = 0; j < shark.speed; j++) {
                int nr = shark.x + dir[shark.dir][0];
                int nc = shark.y + dir[shark.dir][1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    shark.x -= dir[shark.dir][0];
                    shark.y -= dir[shark.dir][1];
                    shark.dir = (shark.dir + 2) % 4;
                    continue;
                }

                shark.x = nr;
                shark.y = nc;
            }

            if (map[shark.x][shark.y] >= 1) {
                if (sharks[map[shark.x][shark.y]].size < shark.size) {
                    map[shark.x][shark.y] = shark.num;
                }
            } else {
                map[shark.x][shark.y] = shark.num;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        sharks = new Shark[m+1];
        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int sz = Integer.parseInt(st.nextToken());

            if (sd == 1) {
                sd = 0;
            } else if (sd == 4) {
                sd = 1;
            }

            map[sr-1][sc-1] = i;
            sharks[i] = new Shark(i, sr-1, sc-1, ss, sd, sz);
        }

        for (int i = 0; i < c; i++) {
            fishing(i);
            sharkMove();
        }

        int answer = 0;
        for (int i = 0; i < fishing.size(); i++) {
            answer += sharks[fishing.get(i)].size;
        }
        System.out.println(answer);
    }
}