import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[][] arr;
    static int N;
    static int[] student;
    static List<Integer>[] likes;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static class Seat implements Comparable<Seat> {
        int x;
        int y;
        int near;
        int like;

        public Seat(int x, int y, int near, int like) {
            this.x = x;
            this.y = y;
            this.near = near;
            this.like = like;
        }

        @Override
        public int compareTo(Seat o) {
            if (this.like > o.like) { return -1; }
            if (this.like < o.like) { return 1; }
            if (this.near > o.near) { return -1; }
            if (this.near < o.near) { return 1; }
            if (this.x < o.x) { return -1; }
            if (this.x > o.x) { return 1; }
            if (this.y < o.y) { return -1; }

            return 1;
        }
    }

    public static void seatDown(int now) {
        PriorityQueue<Seat> queue = new PriorityQueue<>();

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                int near = 0;
                int like = 0;
                if (arr[i][j] != 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    
                    if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                        for (int l = 0; l < 4; l++) {
                            if (likes[now].get(l) == arr[nx][ny]) {
                                like++;
                            }
                        }
                        if (arr[nx][ny] == 0) {
                            near++;
                        }
                    }
                }
                queue.add(new Seat(i, j, near, like));
            }
        }
        Seat seat = queue.poll();
        arr[seat.x][seat.y] = now;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        student = new int[N*N+1];
        likes = new List[N*N+1];
        for (int i = 1; i < N*N+1; i++) {
            st = new StringTokenizer(br.readLine());
            student[i] = Integer.parseInt(st.nextToken());
            likes[student[i]] = new ArrayList<>();

            for (int j = 0; j < 4; j++) {
                likes[student[i]].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < student.length; i++) {
            seatDown(student[i]);
        }

        int answer = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                int like = 0;
                int now = arr[i][j];

                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];

                    if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                        if (likes[now].contains(arr[nx][ny])) {
                            like++;
                        }
                    }
                }

                if (like == 1) { answer += 1; continue; }
                if (like == 2) { answer += 10; continue; }
                if (like == 3) { answer += 100; continue; }
                if (like == 4) { answer += 1000; }
            }
        }
        System.out.println(answer);
    }
}