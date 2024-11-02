import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int n;
    static int[][] visited, map;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static PriorityQueue<Block> pq = new PriorityQueue();

    static class Block implements Comparable<Block>{
        int x;
        int y;
        int change;

        public Block (int x, int y, int change) {
            this.x = x;
            this.y = y;
            this.change = change;
        }


        @Override
        public int compareTo(Block o) {
            return this.change - o.change;
        }
    }
    public static int dijkstra() {
        visited[0][0] = 0;
        pq.add(new Block(0, 0, 0));

        while (!pq.isEmpty()) {
            Block now = pq.poll();

            if (visited[now.x][now.y] < now.change) continue;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int change = map[nx][ny] == 0 ? now.change + 1 : now.change;

                    if (visited[nx][ny] > change) {
                        visited[nx][ny] = change;
                        pq.add(new Block(nx, ny, change));
                    }
                }
            }
        }

        return visited[n-1][n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int INF = 2500;
        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            Arrays.fill(visited[i], INF);
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        System.out.println(dijkstra());
    }
}