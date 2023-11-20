import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> places = new ArrayList<>();
        HashMap<String, int[]> times = new HashMap<>();
        ArrayList<String[]> maxplace = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            if (names.contains(name)) {
                continue;
            }

            names.add(name);
            String place = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (!times.containsKey(place))
                times.put(place, new int[50001]);

            for (int j = start; j < end; j++)
                times.get(place)[j]++;

            if (maxplace.isEmpty()) {
                maxplace.add(new String[]{place, "1"});
            } else {
                String placename = maxplace.get(maxplace.size() - 1)[0];
                int cnt = Integer.parseInt(maxplace.get(maxplace.size() - 1)[1]);
                maxplace.remove(maxplace.size() - 1);

                int maxTime = Arrays.stream(times.get(place)).max().getAsInt();
                if (cnt < maxTime) {
                    cnt = maxTime;
                    placename = place;
                    maxplace.clear();
                } else if (cnt == maxTime) {
                    maxplace.add(new String[]{place, Integer.toString(maxTime)});
                }
                maxplace.add(new String[]{placename, Integer.toString(cnt)});
            }
            if (!places.contains(place))
                places.add(place);
        }

        String p;
        int maxx;
        if (maxplace.size() == 1) {
            p = maxplace.get(0)[0];
            maxx = Integer.parseInt(maxplace.get(0)[1]);
        } else {
            maxplace.sort(Comparator.comparing(x -> x[0]));
            p = maxplace.get(0)[0];
            maxx = Integer.parseInt(maxplace.get(0)[1]);
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int x = 0; x < 50001; x++) {
            if (times.get(p)[x] == maxx) {
                start = x;
                break;
            }
        }
        int end = 0;
        for (int x = start; x < 50001; x++) {
            if (times.get(p)[x] != maxx) {
                end = x;
                break;
            }
        }
        sb.append(p).append(" ").append(start).append(" ").append(end);
        System.out.println(sb);
    }
}