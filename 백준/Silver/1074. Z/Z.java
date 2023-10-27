import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;
    static int cnt = 0;

    public static void partition(int row, int col, int size) {
        if (size == 1) {
            return;
        }

        int half = size / 2;

        if (r < row + half && c < col + half) {
            partition(row, col, half);
        }
        if (r < row + half && c >= col + half) {
            cnt += (size*size) / 4;
            partition(row, col + half, half);
        }
        if (r >= row + half && c < col + half) {
            cnt += ((size*size) / 4) * 2;
            partition(row + half, col, half);
        }
        if (r >= row + half && c >= col + half) {
            cnt += ((size*size) / 4) * 3;
            partition(row + half, col + half, half);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(2, N);

        partition(0, 0, len);

        System.out.println(cnt);
    }
}