import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N, M;
	static boolean[][] visited;
	static int[][] arr;
	static int count;
	static int draw;
	static int ans1 = 0;
	static int ans2 = 0;
	
	public static int bfs(int x, int y) {
		visited[x][y] = true;
		count = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while (!queue.isEmpty()) {
			int[] loc = queue.poll();
			int xx = loc[0];
			int yy = loc[1];
			
			for (int i = 0; i < d.length; i++) {
				int nx = xx + d[i][0];
				int ny = yy + d[i][1];
				
				if ((nx >= 0 && nx < N) && (ny >= 0 && ny < M) && arr[nx][ny] == 1 && !visited[nx][ny]) {
					count++;
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && visited[i][j] == false) {
					draw = bfs(i,j);
					ans2 = Math.max(draw, ans2);
					ans1++;
				}
			}
		}
		
		if (ans1 == 0 && ans2 == 0) {
			System.out.println("0");
			System.out.println("0");
		} else {
			System.out.println(ans1);
			System.out.println(ans2);
		}
		
	}
}