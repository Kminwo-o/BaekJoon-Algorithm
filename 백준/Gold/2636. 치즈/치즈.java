import java.io.*;
import java.util.*;

class Node {
    int x, y;

    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N,M,time=0;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] arr;
    static int last_cheese;
    static boolean not_cheese = false;
    static Queue<Node> q = new LinkedList<>();
    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void bfs(Node x) {
        q.add(x);
        boolean[][] visited = new boolean[N][M];
        List<Node> delete_cheese = new ArrayList<>();
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dir[i][0];
                int ny = now.y + dir[i][1];

                if ((nx >= 0 && nx < N) && (ny >= 0 && ny < M)) {
                    if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    } else if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        delete_cheese.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        last_cheese = delete_cheese.size();

        for (int i = 0; i < delete_cheese.size(); i++) {
            Node now = delete_cheese.get(i);
            arr[now.x][now.y] = 0;
        }

        not_cheese = check();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (!not_cheese) {
            bfs(new Node(0,0));
            time ++;
        }

        System.out.println(time);
        System.out.println(last_cheese);
    }
}