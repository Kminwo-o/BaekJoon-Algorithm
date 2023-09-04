import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Node {
        int x;
        int y;
        int step;
        int[][] maps;

        public Node(int x, int y, int step, int[][] maps) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.maps = maps;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, maps));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];

                if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m)) {
                    if (nx == n-1 && ny == m-1) {
                        answer = Math.max(answer, node.step+1);
                        return answer;
                    } else if (maps[nx][ny] == 1) {
                        node.maps[nx][ny] = 2;
                        queue.add(new Node(nx, ny, node.step+1, node.maps));

                    }
                }
            }
        }

        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }
}