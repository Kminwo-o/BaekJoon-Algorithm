import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    static int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static void IslandBfs (int x, int y, int islandNum) {
        Queue<int[]> queue = new LinkedList();
        visited[x][y] = true;
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            arr[now[0]][now[1]] = islandNum;

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && arr[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
    static void bfs(int x, int y, int islandNum) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 1));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.cnt >= answer) return;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] != 0 && arr[nx][ny] != islandNum) {
                    answer = node.cnt;
                    return;
                }

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, node.cnt + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int island = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    IslandBfs(i, j, island);
                    island++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dir[k][0];
                        int nj = j + dir[k][1];

                        if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                            if (arr[ni][nj] == 0) {
                                bfs(ni, nj, arr[i][j]);
                                visited = new boolean[n][n];
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}