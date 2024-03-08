import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, l;
    static int[][] arr;
    static boolean[][] visited;
    static boolean mapOut(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        return true;
    }
    static boolean downAble (int x, int y) {
        int num = arr[x][y];
        for (int i = x; i < x + l; i++) {
            if (!mapOut(i, y)) return false;
            if (arr[i][y] != num) return false;
            if (visited[i][y]) return false;
        }

        for (int i = x; i < x + l; i++) {
            visited[i][y] = true;
        }

        return true;
    }

    static boolean upAble (int x, int y) {
        int num = arr[x - 1][y];
        for (int i = x - 1; i >= x - l; i--) {
            if (!mapOut(i, y)) return false;
            if (arr[i][y] != num) return false;
            if (visited[i][y]) return false;
        }

        for (int i = x - 1 ; i >= x - l; i--) {
            visited[i][y] = true;
        }
        return true;
    }

    static boolean rightUpAble (int x, int y) {
        int num = arr[x][y - 1];
        for (int i = y - 1; i >= y - l; i--) {
            if (!mapOut(x, i)) return false;
            if (arr[x][i] != num) return false;
            if (visited[x][i]) return false;
        }

        for (int i = y - 1; i >= y - l ; i--) {
            visited[x][i] = true;
        }

        return true;
    }

    static boolean rightDownAble (int x, int y) {
        int num = arr[x][y];
        for (int i = y; i < y + l; i++) {
            if (!mapOut(x, i)) return false;
            if (arr[x][i] != num) return false;
            if (visited[x][i]) return false;
        }

        for (int i = y; i < y + l; i++) {
            visited[x][i] = true;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nowX = 0;
        int nowY = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            nowX = 0;
            for (int j = 1; j < n; j++) {
                int distance = Math.abs(arr[j][i] - arr[nowX][i]);

                if (distance > 1) break;
                if (distance == 0) {
                    nowX++;
                    continue;
                }

                if (arr[nowX][i] - arr[j][i] == 1) {
                    if (downAble(j, i)) {
                        j += l - 1;
                        nowX = j;
                    } else {
                        break;
                    }
                } else {
                    if (upAble(j, i)) {
                        nowX = j;
                    } else {
                        break;
                    }
                }
            }

            if (nowX == n - 1) {
                answer++;
            }
        }


        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            nowY = 0;
            for (int j = 1; j < n; j++) {
                int distance = Math.abs(arr[i][j] - arr[i][nowY]);

                if (distance > 1) break;
                if (distance == 0) {
                    nowY++;
                    continue;
                }

                if (arr[i][j] - arr[i][nowY] == 1) {
                    if (rightUpAble(i, j)) {
                        nowY = j;
                    } else {
                        break;
                    }
                } else {
                    if (rightDownAble(i, j)) {
                        j += l-1;
                        nowY = j;
                    } else {
                        break;
                    }
                }
            }

            if (nowY == n - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}