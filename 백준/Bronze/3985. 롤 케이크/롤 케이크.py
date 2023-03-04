a = int(input())
arr = [0] * (a+1)
h = int(input())
cnt = [0] * (h+1)
xy_lst = []

for i in range(1, h+1):
    x, y = map(int, input().split())
    xy_lst.append((x,y,i))
    for j in range(x, y+1):
        if arr[j] == 0:
            arr[j] = i

max_xy = 0
idx = 0
for x, y, i in xy_lst:
    if y-x > max_xy:
        max_xy = y-x
        idx = i

for i in arr:
    cnt[i] += 1

ii = 0
idxx = 0

for i in range(1, len(cnt)):
    if cnt[i] > ii:
        ii = cnt[i]
        idxx = i

print(idx)
print(idxx)