num = int(input())

max_list = []
for i in range(1, num + 1):
    num_lst = [num]
    num_lst.append(i)

    idx = 1
    while True:
        next_num = num_lst[idx - 1] - num_lst[idx]
        if next_num < 0:
            break
        num_lst.append(next_num)
        idx += 1

    if len(max_list) < len(num_lst):
        max_list = num_lst

print(len(max_list))
print(*max_list)