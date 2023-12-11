import sys
from heapq import heappush, heappop
input = sys.stdin.readline

def prim():
    answer = []
    queue = []
    queue.append((0, 1))

    while queue:
        cur_cost, cur_now = heappop(queue)

        if visited[cur_now] == False:
            visited[cur_now] = True
            answer.append(cur_cost)
            if len(answer) == n:
                break
            for next_now, next_cost in graph[cur_now]:
                heappush(queue, (next_cost, next_now))
    
    return sum(answer) - max(answer)

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]

for i in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

print(prim())