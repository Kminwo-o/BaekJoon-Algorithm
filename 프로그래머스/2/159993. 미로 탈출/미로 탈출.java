import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] dir = {{-1 ,0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static int bfs(int[] S, char[][] arr, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visitedNot = new boolean[n][m];
        boolean[][] visitedOk = new boolean[n][m];
        queue.add(new int[] {S[0], S[1], 0, 0});
        visitedNot[S[0]][S[1]] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if (arr[now[0]][now[1]] == 'E' && now[2] == 1) {
                return now[3];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != 'X') {
                    if (!visitedNot[nx][ny] && now[2] == 0) {
                        visitedNot[nx][ny] = true;
                        if (arr[nx][ny] == 'L') {
                            queue.add(new int[] {nx, ny, 1, now[3] + 1}); 
                        } else {
                            queue.add(new int[] {nx, ny, 0, now[3] + 1});
                        }
                    } else if (!visitedOk[nx][ny] && now[2] == 1) {
                        visitedOk[nx][ny] = true;
                        queue.add(new int[] {nx, ny, 1, now[3] + 1});
                    }
                }
            }
            
        }
        
        return -1;
        
    }
    
    
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        int[] S = new int[2];
        char[][] arr = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = maps[i].charAt(j);
                if (arr[i][j] == 'S') {
                    S[0] = i;
                    S[1] = j;
                }
            }
        }
        
        answer = bfs(S, arr, n, m);
        
        return answer;
    }
}