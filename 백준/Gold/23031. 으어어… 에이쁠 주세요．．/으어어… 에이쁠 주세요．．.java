import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
*  1,1 -> 출발지 , 왼쪽 맨위
*  F -> 앞으로 한칸 전진
*  L -> 왼쪽으로 방향 전환
*  R -> 오른쪽으로 방향 전환
*  
* 아리는 부딪히면 멈춘다.
* 
* s 도착 시 스위치 킴 -> 해당 위치와 1칸범위 모두 밝아짐
* 
* */

public class Main {
    static int N;
    static char[][] catArr;
    static boolean[][] lightArr;
    static List<Zombie> zombies;

    static int[] dir = {0, 1, 2, 3};
    static int[][] direc = {{1 ,0}, {0, 1}, {-1, 0}, {0, -1}}; // 아래, 좌, 위, 우
    static int[][] onLight = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static class Zombie {
        int x;
        int y;
        int dir;

        public Zombie(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static String bfs (String cmd) {
        int[] ahri = {0, 0, 0};
        if (catArr[0][0] == 'S') {
            turnOnLight(0, 0);
        }

        // 명령 수행
        for (int i = 0; i < cmd.length(); i++) {
            char command = cmd.charAt(i);
            int x = ahri[0];
            int y = ahri[1];
            int direct = ahri[2];

            if (command == 'F') {
                int nx = x + direc[dir[direct]][0];
                int ny = y + direc[dir[direct]][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    ahri[0] = nx;
                    ahri[1] = ny;

                    if (catArr[nx][ny] == 'S') {
                        turnOnLight(nx, ny);
                    }
                }
            } else if (command == 'L') {
                ahri[2] = (ahri[2] + 1) % 4;
            } else {
                ahri[2] = (ahri[2] + 3) % 4;
            }

            if (!zombieWorking(ahri)) {
                return "Aaaaaah!";
            }
        }
        return "Phew...";
    }

    public static void turnOnLight (int x, int y) {
        lightArr[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int lx = x + onLight[i][0];
            int ly = y + onLight[i][1];

            if (lx >= 0 && lx < N && ly >= 0 && ly < N) {
                lightArr[lx][ly] = true;
            }
        }
    }

    public static boolean zombieWorking(int[] ahri) {
        for (int i = 0; i < zombies.size(); i++) {
            Zombie zombie = zombies.get(i);

            if (zombie.x == ahri[0] && zombie.y == ahri[1]) {
                if (!lightArr[ahri[0]][ahri[1]]) {
                    return false;
                }
            }

            int nx = zombie.x + direc[dir[zombie.dir]][0];
            int ny = zombie.y + direc[dir[zombie.dir]][1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (ahri[0] == nx && ahri[1] == ny) {
                    if (!lightArr[ahri[0]][ahri[1]]) {
                        return false;
                    }
                }
                zombie.x = nx;
                zombie.y = ny;
            } else {
                zombies.get(i).dir = (zombie.dir + 2) % 4;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String command = br.readLine();

        catArr = new char[N][N];
        lightArr = new boolean[N][N];

        zombies = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                catArr[i][j] = line.charAt(j);
                if (catArr[i][j] == 'Z') {
                    zombies.add(new Zombie(i, j, 0));
                }
            }
        }
        System.out.println(bfs(command));
    }
}