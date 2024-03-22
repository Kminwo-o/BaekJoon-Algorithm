import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int w, h;
  static int[][] arr;
  static boolean[][] visited;
  static int[][] dir = new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
  static void bfs (int x, int y) {
    Queue<int[]> queue = new LinkedList();
    queue.add(new int[] {x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int i = 0; i < 8; i++) {
        int nx = now[0] + dir[i][0];
        int ny = now[1] + dir[i][1];

        if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
          if (!visited[nx][ny] && arr[nx][ny] == 1) {
            queue.add(new int[] {nx, ny});
            visited[nx][ny] = true;
          }
        }
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      if (w == 0 && h == 0) {
        break;
      }
      
      arr = new int[h][w];
      visited = new boolean[h][w];

      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int answer = 0;
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (arr[i][j] == 1 && !visited[i][j]) {
            bfs(i, j);
            answer++;
          }
        }
      }

      System.out.println(answer);
    }  
  }
}