import java.util.*;

public class Solution {
    public int N, D;
    public List<Integer>[] graph;
    public int[] answer;

    public class Point {
        int now;
        int next;
        public Point (int now, int next) {
            this.now = now;
            this.next = next;
        }
    }

    public int dijkstra() {
        Queue<Point> q = new ArrayDeque<>();
        answer[D] = 0;
        q.add(new Point(D, 0));

        while(!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < graph[point.now].size(); i++) {
                int nextN = graph[point.now].get(i);

                if (answer[nextN] != -1) continue;

                answer[nextN] = point.next + 1;
                q.add(new Point(nextN, point.next + 1));
            }
        }
        return -1;
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        answer = new int[n+1];
        Arrays.fill(answer, -1);
        N = n;
        D = destination;

        graph = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int now = roads[i][0];
            int next = roads[i][1];

            graph[now].add(next);
            graph[next].add(now);
        }

        dijkstra();
        int[] ans = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            ans[i] = answer[sources[i]];
        }

        return ans;
    }
}