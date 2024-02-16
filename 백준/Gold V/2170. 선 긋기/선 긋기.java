import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static class Line implements Comparable<Line>{
        int x;
        int y;

        public Line (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line o) {
            if (this.x == o.x) return this.y - o.y;

            return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Line[] line = new Line[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            line[i] = new Line(x, y);
        }

        Arrays.sort(line);

        int answer = line[0].y - line[0].x;
        int end = line[0].y;
        for (int i = 1; i < n; i++) {
            Line now = line[i];
            if (end < now.y && end < now.x) {
                answer += now.y - now.x;
                end = now.y;
            } else if (end < now.y) {
                answer += now.y - end;
                end = now.y;
            }
        }

        System.out.println(answer);
    }
}