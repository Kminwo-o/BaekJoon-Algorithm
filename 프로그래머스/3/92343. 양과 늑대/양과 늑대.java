import java.util.List;
import java.util.ArrayList;

class Solution {
    int[] treeInfo;
    List<Integer>[] graph;
    int maxSheep = 0;
    public void dfs(int idx, int sheepCnt, int wolfCnt, List<Integer> nextList) {
        if (treeInfo[idx] == 0) sheepCnt++;
        else wolfCnt++;

        if (wolfCnt >= sheepCnt) return;

        maxSheep = Math.max(sheepCnt, maxSheep);

        List<Integer> newList = new ArrayList<>();
        newList.addAll(nextList);
        newList.remove(Integer.valueOf(idx));

        for (int next : graph[idx]) {
            newList.add(next);
        }

        for (int next: newList) {
            dfs(next, sheepCnt, wolfCnt, newList);
        }
    }
    public int solution(int[] info, int[][] edges) {
        treeInfo = info;
        graph = new List[info.length];

        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e: edges) {
            int parent = e[0];
            int child = e[1];

            graph[parent].add(child);
        }

        List<Integer> nextList = new ArrayList<>();
        nextList.add(0);
        dfs(0, 0, 0, nextList);

        return maxSheep;
    }
}