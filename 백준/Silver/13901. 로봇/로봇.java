import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K;
    static int[][] arr;
    static int[] dec = new int[4];
    static int[] now;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void robotMoving(int x, int y) {
        arr[x][y] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        int cur = 0;
        int direct = dec[cur];

        while(!q.isEmpty()) {
            now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dir[direct][0];
                int ny = now[1] + dir[direct][1];

                if ((nx >= 0 && nx < R) && (ny >= 0 && ny < C)) {
                    if (arr[nx][ny] == -1) {
                        arr[nx][ny] = arr[now[0]][now[1]] + 1;
                        q.add(new int[] {nx, ny});
                        break;
                    }
                }
                cur++;
                direct = dec[cur % 4];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(arr[i], -1);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int brr = Integer.parseInt(st.nextToken());
            int bcc = Integer.parseInt(st.nextToken());
            arr[brr][bcc] = -2;
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            dec[i] = Integer.parseInt(st.nextToken())-1;
        }
        robotMoving(startX, startY);
        System.out.println(now[0] + " " + now[1]);
    }
}