import sys
input = sys.stdin.readline

def find(n):
    if parent[n] != n:
        parent[n] = find(parent[n])
    return parent[n]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, input().split())
graph = []
parent = [i for i in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph.append((a, b, c))

graph.sort(key=lambda x : x[2])

answer = 0
last_cost = 0
for a, b, c in graph:
    if find(a) != find(b):
        union(a, b)
        answer += c
        last_cost = c

print(answer - last_cost)