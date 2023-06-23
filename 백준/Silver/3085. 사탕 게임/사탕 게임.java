import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int max = 1;
    static char[][] arr;
    public static void swap(int x1, int y1, int x2, int y2) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
    public static int col_check(int y) {
        int tmp = 1, res = 1;
        char c = arr[0][y];
        for (int i = 1; i < N; i++) {
            if (arr[i][y] != c) {
                c = arr[i][y];
                res = Math.max(res,tmp);
                tmp = 1;
            } else tmp++;
        }
        return Math.max(res, tmp);
    }
    public static int row_check(int x) {
        int tmp = 1, res = 1;
        char c = arr[x][0];
        for (int i = 1; i < N; i++) {
            if (arr[x][i] != c) {
                c = arr[x][i];
                res = Math.max(res,tmp);
                tmp = 1;
            } else tmp++;
        }
        return Math.max(res, tmp);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String tmp_str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp_str.charAt(j);
            }
            max = Math.max(max, row_check(i));
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, col_check(i));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 마지막건 어차피 비교하지 않음
                if (j+1 < N) {
                    swap(i,j,i,j+1);
                    max = Math.max(max,row_check(i));
                    max = Math.max(max,col_check(j));
                    max = Math.max(max,col_check(j+1));
                    swap(i,j,i,j+1);
                }
                // 마찬가지
                if (i+1 < N) {
                    swap(i,j,i+1,j);
                    max = Math.max(max, row_check(i));
                    max = Math.max(max, row_check(i+1));
                    max = Math.max(max, col_check(j));
                    swap(i,j,i+1,j);
                }
            }
        }
        System.out.println(max);
    }
}