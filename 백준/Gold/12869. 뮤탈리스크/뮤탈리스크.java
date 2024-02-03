import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] attacks = {{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -9, -3}, {-1, -3, -9}};
    static int[][][] dp = new int[61][61][61];
    static int[] scvList = new int[3];
    static int min = Integer.MAX_VALUE;

    public static void dfs(int[] scv, int cnt) {
        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];

        if (min <= cnt) return;
        if (dp[s1][s2][s3] != 0 && dp[s1][s2][s3] <= cnt) return;

        dp[s1][s2][s3] = cnt;

        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < 6; i++) {
            dfs(new int[] {Math.max(s1 + attacks[i][0], 0), Math.max(s2 + attacks[i][1], 0), Math.max(s3 + attacks[i][2], 0)}, cnt+1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scvList[i] = Integer.parseInt(st.nextToken());
        }

        dfs(scvList, 0);

        System.out.println(min);
    }
}
