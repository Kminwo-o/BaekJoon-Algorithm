import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    static int[][] arr;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void check() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 1) {
                    arr[i][j] -= 1;
                }
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];

                        if (x >= 0 && x < R && y >= 0 && y < C && arr[x][y] != 1) {
                            arr[x][y] = 0;
                        }
                    }
                }
            }
        }
    }

    static void makeBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 3;
                } else {
                    arr[i][j] -= 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

//        for (int i = 0; i < R; i++) {
//            Arrays.fill(arr[i], -1);
//        }

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'O') {
                    arr[i][j] = 3;
                }
            }
        }

        int time = 1;

        check();

        while (time < N) {
            makeBomb();
            time++;
            if (time >= N) {
                break;
            }
            check();
            time++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] >= 1) {
                    sb.append('O');
                } else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}