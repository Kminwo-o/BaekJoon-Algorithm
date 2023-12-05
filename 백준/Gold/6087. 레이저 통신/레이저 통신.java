import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static char[][] arr;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static Node start, end;
    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int mirror;
        int dir;

        public Node (int x, int y, int mirror, int dir) {
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node o) {
            return this.mirror - o.mirror;
        }
    }

    public static int bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        int[][][] visited = new int[4][H][W];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < H; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        queue.add(start);
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == end.x && node.y == end.y) {
                min = Math.min(min, node.mirror);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];

                if ((nx < 0 || nx >= H || ny < 0 || ny >= W) || arr[nx][ny] == '*' || Math.abs(node.dir - i) == 2) continue;

                if (node.dir == i || node.dir == 10) {
                    if (visited[i][nx][ny] > node.mirror) {
                        visited[i][nx][ny] = node.mirror;
                        queue.add(new Node(nx, ny, node.mirror, i));
                    }
                } else {
                    if (visited[i][nx][ny] > node.mirror + 1) {
                        visited[i][nx][ny] = node.mirror + 1;
                        queue.add(new Node(nx,ny, node.mirror+1, i));
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new char[H][W];
        int flag = 1;
        for (int i = 0; i < H; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 'C') {
                    if (flag == 1) {
                        start = new Node(i,j,0,10);
                        flag++;
                    } else {
                        end = new Node(i,j,0,10);
                    }
                }
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }
}