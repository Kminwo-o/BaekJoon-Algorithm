import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr, room;
    static int[] region = new int[2501];
    static int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static void bfs (int x, int y, int roomNumber) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        room[x][y] = roomNumber;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            region[roomNumber]++;

            int wall = arr[now[0]][now[1]];
            for (int i = 0; i < 4; i++) {
                int[] temp;
                if (wall % 2 == 0) {
                    if (i == 0) {
                        temp = new int[] {now[0], now[1] - 1};
                    } else if (i == 1) {
                        temp = new int[] {now[0] - 1, now[1]};
                    } else if (i == 2) {
                        temp = new int[] {now[0], now[1] + 1};
                    } else {
                        temp = new int[] {now[0] + 1, now[1]};
                    }

                    if (temp[0] >= 0 && temp[0] < m && temp[1] >= 0 && temp[1] < n && room[temp[0]][temp[1]] == 0) {
                        queue.add(temp);
                        room[temp[0]][temp[1]] = roomNumber;
                    }
                }
                wall /= 2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        room = new int[m][n];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int roomNumber = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (room[i][j] == 0) {
                    bfs(i, j, roomNumber);
                    roomNumber++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomNumber - 1).append('\n');

        int max = 0;
        for (int i = 1; i < roomNumber; i++) {
            max = Math.max(max, region[i]);
        }
        sb.append(max).append('\n');

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && room[i][j] != room[nx][ny]) {
                        answer = Math.max(answer, region[room[i][j]] + region[room[nx][ny]]);
                    }
                }
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }
}