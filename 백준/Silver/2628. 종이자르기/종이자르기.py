N, M = map(int, input().split())

dot = int(input())
cut_x_lst = [0, M]
cut_y_lst = [0, N]
for _ in range(dot):
    a, b = map(int, input().split())

    if a == 0:
        cut_x_lst.append(b)
    elif a == 1:
        cut_y_lst.append(b)

cut_x_lst.sort()
cut_y_lst.sort()

max_ = 0

for i in range(1, len(cut_x_lst)):
    for j in range(1, len(cut_y_lst)):
        w = cut_x_lst[i] - cut_x_lst[i - 1]
        h = cut_y_lst[j] - cut_y_lst[j - 1]
        max_ = max(max_, w * h)

print(max_)