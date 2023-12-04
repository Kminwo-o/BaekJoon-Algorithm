import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static boolean finish = false;
    static int[][] ladder;
    static int answer;

    public static boolean check() {
        for (int i = 1; i <= N; i++) {
            int x = 1, y = i;
            for (int j = 0; j < H; j++) {
                if (ladder[x][y] == 3) y++;
                else if (ladder[x][y] == 2) y--;
                x++;
            }
            if (y != i) return false;
        }
        return true;
    }
    public static void dfs(int depth, int count) {
        if (finish) return;
        if (answer == count) {
            if (check()) finish = true;
            return;
        }

        for (int i = depth; i < H+1; i++) {
            for (int j = 1; j < N; j++) {
                if (ladder[i][j] == 0 && ladder[i][j+1] == 0) {
                    ladder[i][j] = 3;
                    ladder[i][j+1] = 2;
                    dfs(i, count + 1);
                    ladder[i][j] = ladder[i][j+1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a][b] = 3;
            ladder[a][b+1] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(1, 0);
            if (finish) break;
        }

        System.out.println((finish) ? answer : -1);
    }
}