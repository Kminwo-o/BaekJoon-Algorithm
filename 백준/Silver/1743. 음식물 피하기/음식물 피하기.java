import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int r, c;
    static boolean[][] arr;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1},{0, 1}};
    public static int bfs (int x, int y) {
        int count = 1;
        arr[x][y] = false;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = xy[0] + dir[i][0];
                int ny = xy[1] + dir[i][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    arr[nx][ny] = false;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken())-1;
            arr[r][c] = true;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j]) {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        System.out.println(ans);
    }
}