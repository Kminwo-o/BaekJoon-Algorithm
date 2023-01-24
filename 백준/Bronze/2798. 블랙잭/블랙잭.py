N, M = map(int, input().split())

num_lst = list(map(int, input().split()))
max_num = 0

for i in range(N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            if num_lst[i] + num_lst[j] + num_lst[k] > M:
                continue

            elif num_lst[i] + num_lst[j] + num_lst[k] > max_num:
                max_num = num_lst[i] + num_lst[j] + num_lst[k]

print(max_num)