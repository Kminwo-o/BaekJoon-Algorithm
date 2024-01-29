import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int n;
    static class Flower implements Comparable<Flower> {
        int startDay;
        int endDay;

        public Flower(int startDay, int endDay) {
            this.startDay = startDay;
            this.endDay = endDay;
        }

        @Override
        public int compareTo(Flower o) {
            // 현재 꽃이 피는 일수가 더 빠르면 앞으로
            if (this.startDay < o.startDay) {
                return -1;
            }

            // 현재 꽃과 다음 꽃이 시작 일이 같을 때, 지는 날이 더 길면
            if (this.startDay == o.startDay) {
                if (this.endDay > o.endDay) {
                    return -1;
                }
                if (this.endDay == o.endDay) {
                    return 0;
                }
                return 1;
            }

            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay);
        }

        Arrays.sort(flowers);

        int startDay = 301;
        int endDay = 1201;
        int count = 0;
        int max = 0;
        int idx = 0;

        while (startDay < endDay) {
            boolean findFlower = false;

            for (int i = idx; i < n; i++) {
                if (flowers[i].startDay > startDay) {
                    break;
                }
                if (max < flowers[i].endDay) {
                    findFlower = true;
                    max = flowers[i].endDay;
                    idx = i + 1;
                }
            }

            if (findFlower) {
                startDay = max;
                count++;
            } else {
                break;
            }
        }

        if (max < endDay) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
}