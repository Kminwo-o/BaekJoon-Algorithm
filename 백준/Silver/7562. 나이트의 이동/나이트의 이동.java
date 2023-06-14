import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, T;
	static int[][] dir = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
	static StringTokenizer st;
	static int[][] visited;
	static int[][] location;
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int now[] = q.poll();
			if (location[1][0] == now[0] && location[1][1] == now[1]) {
				break;
			}
			for (int[] is : dir) {
				int nx = now[0] + is[0];
				int ny = now[1] + is[1];
				
				if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && visited[nx][ny] == 0)  {
					visited[nx][ny] = visited[now[0]][now[1]] + 1;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			visited = new int[N][N];
			location = new int[2][2];
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				location[j][0] = Integer.parseInt(st.nextToken());
				location[j][1] = Integer.parseInt(st.nextToken());
			}
			bfs(location[0][0], location[0][1]);

			System.out.println(visited[location[1][0]][location[1][1]]);
		}
	}
}