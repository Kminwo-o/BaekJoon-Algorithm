import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int max = 0;
	static int cnt;
	static int ans;
	
	public static int rain_drop(int rain) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > rain && !visited[i][j]) {
					queue.add(new int[] {i, j});
					visited[i][j] = true;
					
					while (!queue.isEmpty()) {
						int[] xy = queue.poll();
						for (int k = 0; k < 4; k++) {
							int nx = xy[0] + dir[k][0];
							int ny = xy[1] + dir[k][1];
							
							if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && !visited[nx][ny] && arr[nx][ny] > rain) {
								queue.add(new int[] {nx, ny});
								visited[nx][ny] = true;
							}
						}
					}
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		
		for (int i = 0; i < max+1; i++) {
			cnt = 0;
			ans = Math.max(ans, rain_drop(i));
			visited = new boolean[N][N];
		}
		
		System.out.println(ans);
	}
		
}