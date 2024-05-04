import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int t, n, k, w;
  static int[] time, inDegree, dp;
  static List<Integer>[] graph;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      time = new int[n+1];
      for (int j = 1; j <= n; j++) {
       time[j] = Integer.parseInt(st.nextToken());
      }
      
      graph = new List[n + 1];
      for (int j = 0; j <= n; j++) {
        graph[j] = new ArrayList<>();  
      }

      inDegree = new int[n+1];
      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        graph[a].add(b);
        inDegree[b]++;
      }

      w = Integer.parseInt(br.readLine());

      Queue<Integer> queue = new LinkedList<>();
      dp = new int[n + 1];
      for (int j = 1; j <= n; j++) {
        if (inDegree[j] == 0) {
          queue.add(j);
          dp[j] = time[j];
        }
      }

      while (!queue.isEmpty()) {
        int build = queue.poll();

        if (build == w) {
          sb.append(dp[w]).append("\n");
          break;
        }
        
        for (int next : graph[build]) {
          inDegree[next] -= 1;

          dp[next] = Math.max(dp[next], dp[build] + time[next]);
          if (inDegree[next] == 0) {
            queue.add(next);
          }
        }
      }
    }

    System.out.println(sb);
  }
}