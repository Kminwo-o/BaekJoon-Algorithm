import sys
import heapq
input = sys.stdin.readline

N = int(input())
lst = []
class_room = 1

for _ in range(N):
    S, T = map(int, input().split())
    lst.append((S, T))

lst.sort()
study_time = [lst[0][1]]

for i in range(1, N):
    s, t = lst[i]
    if s >= study_time[0]:
        heapq.heappop(study_time)
        heapq.heappush(study_time, t)
    else:
        class_room += 1
        heapq.heappush(study_time, t)

print(class_room)