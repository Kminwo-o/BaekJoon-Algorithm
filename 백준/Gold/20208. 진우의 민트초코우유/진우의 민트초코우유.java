import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h, answer = 0;
    static int[][] map;
    static boolean[][] mintEat;
    static int[] home;
    static List<int[]> mintChoco = new ArrayList<>();
    public static void dfs (int hp, int eatCnt, int x, int y) {
        if (hp == 0) return;
        
        // 집에 갈 수 있으면 일단 바로 집 갔을 때 값을 저장
        if (Math.abs(home[0] - x) + Math.abs(home[1] - y) <= hp) {
            answer = Math.max(answer, eatCnt);
        }

        // 민초를 더 먹을 수 있는지 확인. 가능하면 민초 먹으러 가기.
        for (int i = 0; i < mintChoco.size(); i++) {
            int[] mincho = mintChoco.get(i);
            int needHp = Math.abs(mincho[0] - x) + Math.abs(mincho[1]- y);
            // 남은 hp가 필요한 hp와 같거나 많고, 아직 안먹은 mintChoco면 먹으러 간다.
            if (needHp <= hp && !mintEat[mincho[0]][mincho[1]]) {
                mintEat[mincho[0]][mincho[1]] = true;
                dfs(hp - needHp + h, eatCnt + 1, mincho[0], mincho[1]);
                mintEat[mincho[0]][mincho[1]] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        mintEat = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    home = new int[] {i, j};
                } else if (map[i][j] == 2) {
                    mintChoco.add(new int[] {i, j});
                }
            }
        }

        dfs(m, 0, home[0], home[1]);

        System.out.println(answer);
    }
}