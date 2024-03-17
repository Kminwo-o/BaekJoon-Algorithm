import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m, k;

    static class Beer implements Comparable<Beer> {
        int v;
        int c;

        public Beer(int v, int c) {
            this.v = v;
            this.c = c;
        }

        public int compareTo(Beer beer) {
            if (this.c == beer.c) {
                return beer.v - this.v;
            }

            return this.c - beer.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        List<Beer> beers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            beers.add(new Beer(v, c));
        }

        Collections.sort(beers);

        int total = 0;
        int answer = -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Beer beer : beers) {
            queue.add(beer.v);
            total += beer.v;

            if (queue.size() > n) {
                total -= queue.poll();
            }

            if (queue.size() == n && total >= m) {
                answer = beer.c;
                break;
            }
        }
        System.out.println(answer);
    }
}