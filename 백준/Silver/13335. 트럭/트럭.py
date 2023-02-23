from collections import deque
import sys
input = sys.stdin.readline

n, w , L = map(int, input().split())
truck_lst = deque(map(int, input().split()))
brige = deque([0] * w)
time = 0
brige_weight = 0

while brige:
    time += 1
    brige_weight -= brige.popleft()

    if truck_lst:
        if brige_weight + truck_lst[0] <= L:
            brige.append(truck_lst.popleft())
            brige_weight += brige[-1]
        else:
            brige.append(0)
    
print(time)
