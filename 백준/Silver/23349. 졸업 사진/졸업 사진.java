import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> place = new ArrayList<>();
        HashMap<String, int[]> time = new HashMap<>();
        ArrayList<String[]> maxplace = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] l = new String[4];
            for (int j = 0; j < 4; j++)
                l[j] = scanner.next();

            if (!name.contains(l[0])) {
                name.add(l[0]);
                if (!time.containsKey(l[1]))
                    time.put(l[1], new int[50001]);

                for (int x = Integer.parseInt(l[2]); x < Integer.parseInt(l[3]); x++)
                    time.get(l[1])[x]++;

                if (maxplace.isEmpty()) {
                    maxplace.add(new String[]{l[1], "1"});
                } else {
                    String placename = maxplace.get(maxplace.size() - 1)[0];
                    int cnt = Integer.parseInt(maxplace.get(maxplace.size() - 1)[1]);
                    maxplace.remove(maxplace.size() - 1);

                    int maxTime = Arrays.stream(time.get(l[1])).max().getAsInt();
                    if (cnt < maxTime) {
                        cnt = maxTime;
                        placename = l[1];
                        maxplace.clear();
                    } else if (cnt == maxTime) {
                        maxplace.add(new String[]{l[1], Integer.toString(maxTime)});
                    }
                    maxplace.add(new String[]{placename, Integer.toString(cnt)});
                }
                if (!place.contains(l[1]))
                    place.add(l[1]);
            }
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

        System.out.print(p + " ");
        int start = 0;
        for (int x = 0; x < 50001; x++) {
            if (time.get(p)[x] == maxx) {
                start = x;
                break;
            }
        }
        int end = 0;
        for (int x = start; x < 50001; x++) {
            if (time.get(p)[x] != maxx) {
                end = x;
                break;
            }
        }
        System.out.println(start + " " + end);
    }
}