import java.util.List;
import java.util.ArrayList;

class Solution {
    int[] treeInfo;
    List<Integer>[] graph;
    int maxSheep = 0;
    public void dfs(int idx, int sheepCnt, int wolfCnt, List<Integer> nextList) {
        // 현재 지점이 양이면 양 카운트 ++;
        if (treeInfo[idx] == 0) sheepCnt++;
        // 아니면 늑대 ++;
        else wolfCnt++;

        // 늑대랑 양이 같거나 더 많으면 리턴
        if (wolfCnt >= sheepCnt) return;

        // 리턴 안됬으면 양 수 갱신
        maxSheep = Math.max(sheepCnt, maxSheep);

        // 현재 지점에서 새로 체크 리스트 만들기.
        List<Integer> newList = new ArrayList<>();
        newList.addAll(nextList);

        // 현재 idx는 빼기.
        newList.remove(Integer.valueOf(idx));

        // 갈 수 있는 곳 추가.
        for (int next : graph[idx]) {
            newList.add(next);
        }

        // 돌만큼 돌려주기.
        for (int next: newList) {
            dfs(next, sheepCnt, wolfCnt, newList);
        }
    }
    public int solution(int[] info, int[][] edges) {
        // DFS에서 써야해서 편하게 전역으로
        treeInfo = info;
        graph = new List[info.length];

        // 트리 만들어주기
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
