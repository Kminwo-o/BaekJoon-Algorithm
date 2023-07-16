import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int H, W, N;
    static boolean ans, find;
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;
    static int[][] Marid;
    static int[][] dir= {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};


    public static void dfs (int time, int[] dao, List<Integer> list) {
        for (int i = time; i < N; i++) {
            find = false;
            for (int j = 0; j < 2; j++) {
                int direc = Marid[i][j];
                int nx = dao[0] + dir[direc][0];
                int ny = dao[1] + dir[direc][1];

                if ((nx >= 0 && nx < H) && (ny >= 0 && ny < W) && arr[nx][ny] != '@') {
                    list.add(direc);
                    find = true;
                    if (arr[nx][ny] == 'Z') {
                        for (int k = 0; k < list.size(); k++) {
                            sb.append(list.get(k));
                        }
                        ans = true;
                        return;
                    } else {
                        dfs(i+1, new int[] {nx, ny}, list);
                        if (ans) return;
                        list.remove(list.size()-1);
                        find = false;
                    }
                }
                if (ans) return;
            }
            if (!find) return;
        }
    }
    public static int chartoint(char c) {
        int num = 0;
        if (c == 'W') {
            num = 0;
        } else if (c == 'A') {
            num = 1;
        } else if (c == 'S') {
            num = 2;
        } else if (c == 'D') {
            num = 3;
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int[] Dao = new int[2];

        arr = new char[H][W];
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'D') {
                    Dao = new int[] {i, j};
                }
            }
        }

        N = Integer.parseInt(br.readLine());
        Marid = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char one = st.nextToken().charAt(0);
            char two = st.nextToken().charAt(0);

            Marid[i][0] = chartoint(one);
            Marid[i][1] = chartoint(two);
        }

        dfs(0, Dao, new ArrayList<>());

        if (ans) {
            System.out.println("YES");
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') System.out.print('W');
                if (sb.charAt(i) == '1') System.out.print('A');
                if (sb.charAt(i) == '2') System.out.print('S');
                if (sb.charAt(i) == '3') System.out.print('D');
            }
        } else {
            System.out.println("NO");
        }
    }
}