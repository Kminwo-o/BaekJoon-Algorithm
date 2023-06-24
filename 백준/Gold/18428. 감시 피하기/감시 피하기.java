import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int cnt = 0;
    static char[][] arr;
    static int[][] CCTV = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<Node> teacher = new ArrayList<>();
    static boolean possible = false;
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean monitoring() {
        Queue<Node> q = new LinkedList<>();
        char[][] copyarr = new char[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyarr[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < teacher.size(); i++) {
            visited[teacher.get(i).x][teacher.get(i).y] = true;
            q.offer(teacher.get(i));
        }

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + CCTV[i][0];
                int ny = now.y + CCTV[i][1];

                while((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
                    if (copyarr[nx][ny] == 'X') {
                        visited[nx][ny] = true;
                        nx += CCTV[i][0];
                        ny += CCTV[i][1];
                    } else if (copyarr[nx][ny] == 'S') {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        return true;
    }
    public static void trap (int wall) {
        if (wall == 3) {
            if (monitoring()) {
                possible = true;
                System.out.println("YES");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (possible) return;
                if (arr[i][j] == 'X') {
                    arr[i][j] = 'O';
                    trap(wall + 1);
                    arr[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine().replaceAll(" ", "");
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'T') {
                    teacher.add(new Node(i,j));
                }
            }
        }

        trap(0);

        if (!possible) {
            System.out.println("NO");
        }
    }
}