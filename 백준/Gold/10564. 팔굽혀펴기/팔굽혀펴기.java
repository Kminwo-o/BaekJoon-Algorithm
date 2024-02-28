import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t, n, m;
    static int[] availableScore = new int[10];
    static boolean[][] dp;
    static class PushUp {
        int score;
        int cnt;

        public PushUp (int score, int cnt) {
            this.score = score;
            this.cnt = cnt;
        }
    }
    public static int bfs () {
        dp = new boolean[501][5001];
        Queue<PushUp> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            int now = availableScore[i];
            queue.add(new PushUp(now, now));
            dp[now][now] = true;
        }

        while (!queue.isEmpty()) {
            PushUp pushUp = queue.poll();

            for (int i = 0; i < m; i++) {
                int nScore = pushUp.score + availableScore[i];
                int nCnt = pushUp.cnt + nScore;

                if (nCnt > n || dp[nScore][nCnt]) continue;

                queue.add(new PushUp(nScore, nCnt));
                dp[nScore][nCnt] = true;
            }
        }

        for (int i = 500; i >= 1; i--) {
            if (dp[i][n]) return i;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                availableScore[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(bfs());
        }
    }
}