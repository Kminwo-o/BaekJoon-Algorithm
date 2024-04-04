import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] arr = new int[9][9];
    static boolean[] zeroArr;
    static List<int[]> zeroIdx = new ArrayList<>();
    public static boolean isValid(int[] idx, int num) {
        int r = idx[0];
        int c = idx[1];

        for (int i = 0; i < 9; i++) {
            if (arr[r][i] == num || arr[i][c] == num) return false;
        }

        int startR = (r / 3) * 3;
        int startC = (c / 3) * 3;

        for (int i = startR; i < startR + 3; i++) {
            for (int j = startC; j < startC + 3; j++) {
                if (arr[i][j] == num) return false;
            }
        }

        return true;
    }
    public static void findNumber(int depth) {
        if (depth == zeroIdx.size()) {
            System.out.println(printSudoku());
            System.exit(0);
        }

        int[] idx = zeroIdx.get(depth);

        for (int i = 1; i <= 9; i++) {
            if (isValid(idx, i)) {
                arr[idx[0]][idx[1]] = i;
                findNumber(depth + 1);
                arr[idx[0]][idx[1]] = 0;
            }
        }
    }

    public static String printSudoku() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if (arr[i][j] == 0) {
                    zeroIdx.add(new int[] {i, j});
                }
            }
        }

        findNumber(0);
    }
}